package de.dfki.iui.basys.common.emf;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.commons.io.output.WriterOutputStream;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 * Some utils for xml
 * 
 * @author kirill
 * 
 */
public class XMLUtils {
	
	/**
	 * Parses the from string.
	 *
	 * @param xmlDoc the xml doc
	 * @return the document
	 * @throws Exception the exception
	 */
	public static Document parseFromString(String xmlDoc) throws Exception {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setValidating(false);
		factory.setNamespaceAware(true);

		DocumentBuilder builder = factory.newDocumentBuilder();
		builder.setErrorHandler(new SyntaxErrorHandler());
		InputSource is = new InputSource(new StringReader(xmlDoc));

		Document document = builder.parse(is);
		return document;
	}

	/**
	 * Returns the value of the child node with the given name.
	 *
	 * @param base the element from where to search.
	 * @param name name of the element to get.
	 * @param namespace the namespace
	 * @param id the id
	 * @return the value of this element.
	 */
	public static Node getChildNodeWithNameAndId(final Element base, final String name, final String namespace, final int id) {
		NodeList nodeList = base.getElementsByTagNameNS(namespace, name);
		Node node = nodeList.item(id);
		return node;
	}

	/**
	 * Copy E object attributes.
	 *
	 * @param memberObject the member object
	 * @param from the from
	 * @param to the to
	 */
	public static void copyEObjectAttributes(EObject memberObject, Element from, Element to) {
		Set<String> objAttrs = new HashSet<String>();

		for (EAttribute attribute : memberObject.eClass().getEAllAttributes()) {
			objAttrs.add(attribute.getName());
		}
		NamedNodeMap attributes = from.getAttributes();
		for (int i = 0; i < attributes.getLength(); i++) {
			Attr node = (Attr) attributes.item(i);
			if (objAttrs.contains(node.getName())) {
				to.setAttributeNS(node.getNamespaceURI(), node.getName(), node.getValue());
			}
		}
	}

	/**
	 * Prints the document.
	 *
	 * @param doc the doc
	 * @param out the out
	 * @param prettyPrint the pretty print
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws TransformerException the transformer exception
	 */
	public static void printDocument(Node doc, OutputStream out, boolean prettyPrint) throws IOException, TransformerException {
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer transformer = tf.newTransformer();
		transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
		transformer.setOutputProperty(OutputKeys.METHOD, "xml");
		if (prettyPrint) {
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
		} else {
			transformer.setOutputProperty(OutputKeys.INDENT, "no");
		}
		transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
		transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

		transformer.transform(new DOMSource(doc), new StreamResult(new OutputStreamWriter(out, "UTF-8")));
	}

	public static void logDocument(Node doc, Logger logger) throws IOException, TransformerException {
		StringWriter stringWriter = new StringWriter();
		WriterOutputStream os = new WriterOutputStream(stringWriter, Charset.forName("UTF-8"));
		printDocument(doc, os, true);
		os.close();
		logger.debug(stringWriter.toString());
	}

	/**
	 * Run xslt.
	 *
	 * @param xslIs the xsl is
	 * @param doc the doc
	 * @param out the out
	 * @throws Exception the exception
	 */
	private static void runXslt(InputStream xslIs, Node doc, OutputStream out) throws Exception {
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer(new StreamSource(xslIs));

		DOMSource source = new DOMSource(doc);
		StreamResult rs = new StreamResult(out);

		transformer.transform(source, rs);
	}

	/**
	 * Strip white spaces.
	 *
	 * @param doc the doc
	 * @param out the out
	 * @throws Exception the exception
	 */
	public static void stripWhiteSpaces(Node doc, OutputStream out) throws Exception {
		runXslt(XMLUtils.class.getResourceAsStream("strip.xsl"), doc, out);
	}

	/**
	 * Collect namespace.
	 *
	 * @param doc the doc
	 * @param namespaces_ the namespaces
	 */
	public static void collectNamespace(Document doc, Map<String, String> namespaces_) {
		if (doc.getDocumentElement().hasAttributes()) {
			NamedNodeMap attributes = doc.getDocumentElement().getAttributes();
			for (int i = 0; i < attributes.getLength(); i++) {
				Attr node = (Attr) attributes.item(i);
				if (node.getName().startsWith("xmlns:")) {
					if (!namespaces_.containsKey(node.getName())) {
						namespaces_.put(node.getName(), node.getValue());
					}
				}
			}
		}
	}
}
