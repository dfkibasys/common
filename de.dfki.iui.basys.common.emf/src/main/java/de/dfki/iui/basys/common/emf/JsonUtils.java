package de.dfki.iui.basys.common.emf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import org.apache.commons.io.input.ReaderInputStream;
import org.apache.commons.io.output.WriterOutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.EMFJs;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	public static Resource fromStream(InputStream input) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = mapper.reader().withAttribute(EMFContext.Attributes.RESOURCE_SET, resourceSet).withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI("in.json"))
				.forType(Resource.class).readValue(input);

		return resource;
	}

	public static Resource fromStream(InputStream input, EClass root) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());

		// Map<String, Object> options = new HashMap<String, Object>();
		// options.put(EMFJs.OPTION_ROOT_ELEMENT, root);

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = mapper.reader().withAttribute(EMFContext.Attributes.RESOURCE_SET, resourceSet).withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI("in.json"))
				.withAttribute(EMFContext.Attributes.ROOT_ELEMENT, root).forType(Resource.class).readValue(input);

		// Resource resource =
		// resourceSet.createResource(URI.createURI("in.json"));

		// StringWriter writer = new StringWriter();
		// IOUtils.copy(input, writer, Charsets.UTF_8);
		// String content = writer.toString();

		// InputStreamReader isr = new
		// InputStreamReader(IOUtils.toInputStream(content,Charsets.UTF_8));

		// try {
		// //resource.load(input, options);
		// resource.load(IOUtils.toInputStream(content,Charsets.UTF_8));
		// } catch (IOException e) {
		//
		// throw e;
		// }
		return resource;
	}

	public static Resource fromJsonString(String input, EClass root) throws IOException {
		StringReader stringReader = new StringReader(input);
		ReaderInputStream is = new ReaderInputStream(stringReader, Charset.forName("UTF-8"));

		return fromStream(is, root);
	}

	public static <T> T fromStream(InputStream input, Class<T> clz) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new EMFModule());

		// Map<String, Object> options = new HashMap<String, Object>();
		// options.put(EMFJs.OPTION_ROOT_ELEMENT, root);

		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		T resource = mapper.reader().withAttribute(EMFContext.Attributes.RESOURCE_SET, resourceSet).withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI("in.json")).forType(clz)
				.readValue(input);

		// Resource resource =
		// resourceSet.createResource(URI.createURI("in.json"));

		// StringWriter writer = new StringWriter();
		// IOUtils.copy(input, writer, Charsets.UTF_8);
		// String content = writer.toString();

		// InputStreamReader isr = new
		// InputStreamReader(IOUtils.toInputStream(content,Charsets.UTF_8));

		// try {
		// //resource.load(input, options);
		// resource.load(IOUtils.toInputStream(content,Charsets.UTF_8));
		// } catch (IOException e) {
		//
		// throw e;
		// }
		return resource;
	}

	public static <T> T fromJsonString(String input, Class<T> clz) throws IOException {
		StringReader stringReader = new StringReader(input);
		ReaderInputStream is = new ReaderInputStream(stringReader, Charset.forName("UTF-8"));
		T result = fromStream(is, clz);
		return result;
	}

	public static void toStream(OutputStream os, EObject entity) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsonResourceFactory());

		Resource resource = resourceSet.createResource(URI.createURI("out.json"));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);

		if (entity.eResource() != null)
			resource.getContents().add(EmfUtils.clone(entity));
		else
			resource.getContents().add(entity);
		resource.save(os, options);
	}

	public static void toStream(OutputStream os, Collection<? extends EObject> entities) throws IOException {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsonResourceFactory());

		Resource resource = resourceSet.createResource(URI.createURI("out.json"));
		Map<String, Object> options = new HashMap<String, Object>();
		options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);
		options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, true);

		entities.forEach(new Consumer<EObject>() {
			@Override
			public void accept(EObject e) {
				if (e.eResource() != null)
					resource.getContents().add(EmfUtils.clone(e));
				else
					resource.getContents().add(e);
			}
		});

		resource.save(os, options);
	}

	public static String toJsonString(EObject entity) throws IOException {
		StringWriter sw = new StringWriter();
		WriterOutputStream os = new WriterOutputStream(sw, Charset.forName("UTF-8"));
		toStream(os, entity);
		return sw.getBuffer().toString();
	}

	public static String toJsonString(Collection<? extends EObject> entities) throws IOException {
		StringWriter sw = new StringWriter();
		WriterOutputStream os = new WriterOutputStream(sw, Charset.forName("UTF-8"));
		toStream(os, entities);
		return sw.getBuffer().toString();
	}

	public static String getStringFromInputStream(InputStream is) {

		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();

		String line;
		try {

			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();

	}

}
