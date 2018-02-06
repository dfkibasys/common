package de.dfki.iui.basys.common.emf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.WriterOutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EPackage.Registry;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.BasicExtendedMetaData;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.util.ExtendedMetaData;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.URIHandlerImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

//import de.dfki.iui.mmds.core.emf.utils.EmfUtils;

public class EmfPersistence {

	static final String HREF_ATTR = "href";
	static final String XMLNS_XSI = "xmlns:xsi";
	static final Logger logger = LoggerFactory.getLogger(EmfPersistence.class);
	static final ExtendedMetaData modelMetaData = new BasicExtendedMetaData(EPackage.Registry.INSTANCE);

	// how to handle uncontainment references?
	public enum NonContainmentReferenceHandling {
		INLINE, // references are integrated inline into as child node
		KEEP_ORIGINAL_LOCATION, // keeps original references to external
								// resources
		ADD_TO_RESOURCE, // adds all external resources to this resource (XMI
							// representation then)
	}

	public static Resource readFromFile(String file) throws IOException {
		URI uri = URI.createFileURI(file);
		return readFromUri(uri);
	}

	public static Resource readFromUri(URI uri) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.createResource(uri);
		read(resource, null);
		return resource;
	}

	public static Resource readFromString(String input) throws IOException {
		StringReader stringReader = new StringReader(input);
		ReaderInputStream is = new ReaderInputStream(stringReader, Charset.forName("UTF-8"));
		Resource resource = readFromStream(is);
		is.close();
		return resource;
	}

	public static Resource readFromStream(InputStream is) throws IOException {
		XMLResourceFactoryImpl factory = new XMLResourceFactoryImpl();

		Resource resource = factory.createResource(URI.createURI(""));
		read(resource, is);
		return resource;
	}

	public static void read(Resource resource, InputStream is) throws IOException {
		Map<Object, Object> loadOptions;
		if (resource.getResourceSet() != null) {
			loadOptions = resource.getResourceSet().getLoadOptions();
		} else {
			loadOptions = new HashMap<Object, Object>();
		}
		loadOptions.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		loadOptions.put(XMIResource.OPTION_ENCODING, "UTF-8");
		loadOptions.put(XMIResource.OPTION_EXTENDED_META_DATA, modelMetaData);
		loadOptions.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		if (is != null) {
			resource.load(is, loadOptions);
		} else {
			resource.load(loadOptions);
		}
	}

	public static Resource writeToFile(EObject instance, String file, NonContainmentReferenceHandling refOption, HashMap<String, Object> saveOptions) throws IOException {
		URI uri = URI.createFileURI(file);
		return writeToUri(instance, uri, refOption, saveOptions);
	}

	public static Resource writeToUri(EObject instance, URI uri, NonContainmentReferenceHandling refOption, HashMap<String, Object> saveOptions) throws IOException {

		Resource resource = new XMLResourceFactoryImpl().createResource(uri);
		write(instance, resource, null, refOption, saveOptions);
		return resource;
	}

	public static String writeToString(EObject instance) throws IOException {
		return writeToString(instance, NonContainmentReferenceHandling.INLINE, null);
	}

	public static String writeToString(EObject instance, NonContainmentReferenceHandling refOption, HashMap<String, Object> saveOptions) throws IOException {
		StringWriter stringWriter = new StringWriter();
		WriterOutputStream os = new WriterOutputStream(stringWriter, Charset.forName("UTF-8"));
		writeToStream(instance, os, refOption, saveOptions);
		os.close();
		return stringWriter.toString();
	}

	public static void writeToStream(EObject instance, OutputStream os, NonContainmentReferenceHandling refOption, HashMap<String, Object> saveOptions) throws IOException {
		XMLResourceFactoryImpl factory = new XMLResourceFactoryImpl();
		Resource resource = factory.createResource(URI.createURI(""));
		write(instance, resource, os, refOption, saveOptions);
	}

	public static void writeToStream(EObject instance, OutputStream os) throws IOException {
		writeToStream(instance, os, NonContainmentReferenceHandling.INLINE, null);
	}

	public static void write(Resource resource, OutputStream os, Map<String, Object> saveOptions) throws IOException {
		ExtendedMetaData modelMetaData;
		if (resource.getResourceSet() != null) {
			modelMetaData = new BasicExtendedMetaData(resource.getResourceSet().getPackageRegistry());
		} else {
			modelMetaData = new BasicExtendedMetaData(Registry.INSTANCE);
		}
		HashMap<String, Object> options = new HashMap<String, Object>();

		options.put(XMIResource.OPTION_ENCODING, "UTF-8");
		if (!options.containsKey(XMIResource.OPTION_KEEP_DEFAULT_CONTENT)) {
			options.put(XMIResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);
		}
		options.put(XMIResource.OPTION_EXTENDED_META_DATA, modelMetaData);
		options.put(XMLResource.OPTION_URI_HANDLER, new URIHandlerImpl.PlatformSchemeAware());
		options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		if (saveOptions != null) {
			options.putAll(saveOptions);
		}
		if (os != null) {
			resource.save(os, options);
		} else {
			resource.save(options);
		}
	}

	private static void write(EObject instance, Resource resource, OutputStream os, NonContainmentReferenceHandling refOption, Map<String, Object> saveOptions) throws IOException {
		if (refOption == null) {
			refOption = NonContainmentReferenceHandling.KEEP_ORIGINAL_LOCATION;
		}
		HashSet<EObject> alreadyVisited = new HashSet<EObject>();
		List<EObject> rootList = new ArrayList<EObject>();

		if (refOption == NonContainmentReferenceHandling.ADD_TO_RESOURCE) {
			instance = EmfUtils.clone(instance);
			resource.getContents().add(instance);
			collectObjectsWithoutResource(instance, alreadyVisited, rootList, refOption);
			resource.getContents().addAll(rootList);
			write(resource, os, saveOptions);
		} else if (refOption == NonContainmentReferenceHandling.KEEP_ORIGINAL_LOCATION) {
			resource.getContents().add(instance);
			collectObjectsWithoutResource(instance, alreadyVisited, rootList, refOption);

			Resource resourceTemp = new XMLResourceFactoryImpl().createResource(URI.createURI(""));
			resourceTemp.getContents().addAll(rootList);
			write(resource, os, saveOptions);
		} else if (refOption == NonContainmentReferenceHandling.INLINE) {
			EObject oldInstance = instance;
			instance = EmfUtils.clone(instance);
			Copier copier = new Copier(false, false);

			resource.getContents().add(instance);
			// Reads to DOM an injects dependencies(replaces href nodes)
			Document d;
			Map<String, String> namespaces = new HashMap<String, String>();
			try {
				d = createDocFromEObject(instance, namespaces);
				Set<EObject> alreadyHandled = new HashSet<EObject>();
				dfs(instance, d.getDocumentElement(), alreadyHandled, namespaces);
				setGlobalNameSpaces(d, namespaces);
				// XMLUtil.stripWhiteSpaces(d, os);
				XMLUtils.printDocument(d, os, true);
				// logger.info(stringWriter.toString());
			} catch (Exception e) {
				logger.error("An error occured while serializing an object:\n" + e.getLocalizedMessage());
				e.printStackTrace();
			}
		}
	}

	/**
	 * Run DFS on EObject reference tree
	 * 
	 * @param object
	 * @param node
	 * @param alreadyHandled
	 * @return
	 * @throws Exception
	 */
	protected static void dfs(EObject object, Element node, Set<EObject> alreadyHandled, Map<String, String> namespaces) throws Exception {

		if (alreadyHandled.contains(object))
			return;
		else {
			alreadyHandled.add(object);
		}

		// traverse references and append them to the document
		for (EReference ref : object.eClass().getEAllReferences()) {
			if (!ref.isTransient())
				if (!ref.isContainment()) {
					if (ref.isMany()) {
						int id = 0;
						for (EObject content : ((List<EObject>) object.eGet(ref))) {
							if (!(content.eClass().getEPackage() instanceof EcorePackage)) {
								Document n = createDocFromEObject(content, namespaces);
								dfs(content, n.getDocumentElement(), alreadyHandled, namespaces);
								updateMember(node, ref, id, content, n);
								id++;
							}
						}
					} else {
						EObject content = ((EObject) object.eGet(ref));
						if (content != null && !(content.eClass().getEPackage() instanceof EcorePackage)) {
							Document n = createDocFromEObject(content, namespaces);
							dfs(content, n.getDocumentElement(), alreadyHandled, namespaces);
							updateMember(node, ref, 0, content, n);
						}
					}
				} else {
					if (ref.isMany()) {
						List<EObject> refList = (List<EObject>) object.eGet(ref);
						for (int id = 0; id < refList.size(); ++id) {
							EObject content = refList.get(id);
							Element childNode = (Element) XMLUtils.getChildNodeWithNameAndId(node, modelMetaData.getName(ref), modelMetaData.getNamespace(ref), id);
							if (childNode != null) {
								dfs(content, childNode, alreadyHandled, namespaces);
							}
						}
					} else {
						EObject content = ((EObject) object.eGet(ref));
						if (content != null && node != null) {
							Element childNode = (Element) XMLUtils.getChildNodeWithNameAndId(node, modelMetaData.getName(ref), modelMetaData.getNamespace(ref), 0);
							if (childNode != null) {
								dfs(content, childNode, alreadyHandled, namespaces);
							}
						}
					}
				}
		}
	}

	/**
	 * 
	 * @param d
	 */
	private static void setGlobalNameSpaces(Document d, Map<String, String> namespaces) {
		d.getDocumentElement().setAttribute(XMLNS_XSI, modelMetaData.XSI_URI);
		for (Map.Entry<String, String> entry : namespaces.entrySet()) {
			if (!d.getDocumentElement().hasAttribute(entry.getKey())) {
				d.getDocumentElement().setAttribute(entry.getKey(), entry.getValue());
			}
		}
	}

	/**
	 * Serialize an object to XML using standard EMF
	 * 
	 * @param object
	 * @return
	 * @throws Exception
	 */
	private static Document createDocFromEObject(EObject object, Map<String, String> namespaces) throws Exception {
		HashMap<String, Object> options = new HashMap<String, Object>();
		options.put(XMIResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.FALSE);
		options.put(XMIResource.OPTION_DECLARE_XML, Boolean.FALSE);
		options.put(XMLResource.OPTION_FORMATTED, Boolean.FALSE);
		options.put(XMLResource.OPTION_KEEP_DEFAULT_CONTENT, Boolean.TRUE);

		String result = writeToString(object, NonContainmentReferenceHandling.KEEP_ORIGINAL_LOCATION, options);
		// System.err.println(result);
		Document doc = null;
		try {
			doc = XMLUtils.parseFromString(result);
			XMLUtils.collectNamespace(doc, namespaces);
		} catch (Exception e) {
			logger.error(e.getMessage());
			assert(false);
		}
		return doc;
	}

	private static void collectObjectsWithoutResource(EObject eObject, HashSet<EObject> alreadyVisited, List<EObject> rootList, NonContainmentReferenceHandling refOption) {

		if (alreadyVisited.contains(eObject))
			return;
		alreadyVisited.add(eObject);
		if ((eObject.eClass().getEPackage() instanceof EcorePackage))
			return;
		if (eObject.eResource() == null) {
			if (eObject.eContainer() == null) {
				rootList.add(eObject);
			} else {
				collectObjectsWithoutResource(eObject.eContainer(), alreadyVisited, rootList, refOption);
			}
		}
		for (EReference eref : eObject.eClass().getEAllReferences()) {
			if (eref.isTransient()) {
				EAnnotation annotation = eref.getEAnnotation("http:///org/eclipse/emf/ecore/util/ExtendedMetaData");
				if (annotation == null || !annotation.getDetails().containsKey("group")) {
					continue;
				}
			}
			final Object value = eObject.eGet(eref);
			if (value == null) {
				continue;
			}
			if (value instanceof List) {
				for (Object obj : (List<?>) value) {
					if (obj == null) {
						logger.error("There seems to be a unresolved reference. Please check the console output!");
					}
					collectObjectsWithoutResource((EObject) obj, alreadyVisited, rootList, refOption);
				}
			} else {
				collectObjectsWithoutResource((EObject) value, alreadyVisited, rootList, refOption);
			}
		}
	}

	/**
	 * Update member contents with resolved data
	 * 
	 * @param node
	 * @param memberReference
	 * @param memberDocument
	 * @return
	 * @throws Exception
	 */
	private static Element updateMember(Element node, EReference memberReference, int id, EObject memberObject, Document memberDocument) throws Exception {
		Node currentMemberNode = XMLUtils.getChildNodeWithNameAndId(node, modelMetaData.getName(memberReference), modelMetaData.getNamespace(memberReference), id);
		if (currentMemberNode != null) {
			logger.debug("Member " + memberReference.getName() + " is going to be replaced");
			logger.debug("Current member contents");
			XMLUtils.logDocument(currentMemberNode, logger);
			logger.debug("Resolved member contents ");
			XMLUtils.logDocument(memberDocument, logger);
			logger.debug("Removing child nodes of " + memberReference.getName());
			for (Node child; (child = currentMemberNode.getFirstChild()) != null; currentMemberNode.removeChild(child)) {
				;
			}
			XMLUtils.logDocument(currentMemberNode, logger);
			logger.debug("Inserting resolved contents to the member");
			for (int i = 0; i < memberDocument.getFirstChild().getChildNodes().getLength(); ++i) {
				Node importedNode = node.getOwnerDocument().importNode(memberDocument.getFirstChild().getChildNodes().item(i), true);
				currentMemberNode.appendChild(importedNode);
			}
			logger.debug("Member after insertion");
			XMLUtils.logDocument(currentMemberNode, logger);
			logger.debug("Removing href attribute");
			if (currentMemberNode.getAttributes().getNamedItem(HREF_ATTR) != null) {
				currentMemberNode.getAttributes().removeNamedItem(HREF_ATTR);
			}
			logger.debug("Member after deleting href");
			XMLUtils.logDocument(currentMemberNode, logger);

			logger.debug("Setting xsi:type");
			Attr attr = currentMemberNode.getOwnerDocument().createAttributeNS(modelMetaData.XSI_URI, "type");
			attr.setValue(memberObject.eClass().getEPackage().getName() + ":" + memberObject.eClass().getName());
			attr.setPrefix("xsi");
			((Element) currentMemberNode).setAttributeNode(attr);
			logger.debug("Member after setting type");
			XMLUtils.logDocument(currentMemberNode, logger);
			logger.debug("Copying resolved member attributes to the member");
			XMLUtils.copyEObjectAttributes(memberObject, memberDocument.getDocumentElement(), (Element) currentMemberNode);
			logger.debug("Member after copying attributes");
			XMLUtils.logDocument(currentMemberNode, logger);
		}
		return node;
	}
}
