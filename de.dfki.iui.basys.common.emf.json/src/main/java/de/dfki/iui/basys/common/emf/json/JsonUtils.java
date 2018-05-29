package de.dfki.iui.basys.common.emf.json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.handlers.BaseURIHandler;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonUtils {

	public static EMFModule module;
	public static ObjectMapper mapper;
	public static ResourceSet resourceSet;

	static {
		module = new EMFModule();		
		
		
		//module.setReferenceInfo(new EcoreReferenceInfo(new IdentityURIHandler()));
		module.setReferenceSerializer  (new MyEcoreReferenceSerializer  (new EcoreReferenceInfo(new BaseURIHandler()), new EcoreTypeInfo()));
		//module.setReferenceDeserializer(new MyEcoreReferenceDeserializer(new EcoreReferenceInfo(new BaseURIHandler()), new EcoreTypeInfo()));
		
		mapper = new ObjectMapper(null);
		// same as emf
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getDefault());

		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.setDateFormat(dateFormat);
		mapper.setTimeZone(TimeZone.getDefault());
		mapper.registerModule(module);	
		
		
		
		resourceSet = new BasysResourceSetImpl();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));
	}

	public static void toStream(OutputStream os, EObject entity) throws JsonGenerationException, JsonMappingException, IOException {
		mapper.writeValue(os, entity);
	}

	public static void toStream(OutputStream os, Collection<? extends EObject> entities) throws IOException {
		// ResourceSet resourceSet = new ResourceSetImpl();
		// Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsonResourceFactory());
		//
		// Resource resource = resourceSet.createResource(URI.createURI("out.json"));
		// Map<String, Object> options = new HashMap<String, Object>();
		// // options.put(EMFJs.OPTION_INDENT_OUTPUT, true);
		// // options.put(EMFJs.OPTION_SERIALIZE_TYPE, false);
		// // options.put(EMFJs.OPTION_SERIALIZE_REF_TYPE, true);
		//
		// entities.forEach(new Consumer<EObject>() {
		// @Override
		// public void accept(EObject e) {
		// if (e.eResource() != null)
		// resource.getContents().add(EmfUtils.clone(e));
		// else
		// resource.getContents().add(e);
		// }
		// });
		//
		// resource.save(os, options);
		mapper.writeValue(os, entities);
	}

	public static String toString(EObject entity) throws JsonProcessingException {
		if (entity.eResource() == null) {
			ResourceSet resourceSet = new ResourceSetImpl();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsonResourceFactory());
			Resource resource = resourceSet.createResource(URI.createURI("out.json"));
			resource.getContents().add(entity);
		}
		String result = mapper.writeValueAsString(entity);
		return result;
	}

	public static Resource fromStream(InputStream input, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = mapper
				.reader()
				.withAttribute(EMFContext.Attributes.RESOURCE_SET, rs)
				.withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI("in.json"))
				.forType(Resource.class)
				.readValue(input);

		return resource;
	}
	
	public static Resource fromStream(InputStream input) throws IOException {
		return fromStream(input, resourceSet);
	}
	
	public static <T> T fromStream(InputStream input, Class<T> clz, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = fromStream(input, rs);

		return (T) resource.getContents().get(0);
	}
	
	public static <T> T fromStream(InputStream input, Class<T> clz) throws IOException { 
		return fromStream(input, clz, resourceSet);
	}
	
	public static Resource fromString(String input, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = mapper
				.reader()
				.withAttribute(EMFContext.Attributes.RESOURCE_SET, rs)
				.withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI("in.json"))
				.forType(Resource.class)
				.readValue(input);

		return resource;
	}
	
	public static Resource fromString(String input) throws IOException {
		return fromString(input, resourceSet);
	}
	
	public static <T> T fromString(String input, Class<T> clz, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = fromString(input, rs);

		return (T) resource.getContents().get(0);
	}
	
	public static <T> T fromString(String input, Class<T> clz) throws IOException { 
		return fromString(input, clz, resourceSet);
	}
	
	
	

	public static Resource fromFile(File file, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = mapper
				.reader()
				.withAttribute(EMFContext.Attributes.RESOURCE_SET, rs)
				.withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI("in.json"))
				.forType(Resource.class)
				.readValue(file);

		return resource;
	}
	
	public static Resource fromFile(File file) throws IOException {
		return fromFile(file, resourceSet);
	}
	
	public static <T> T fromFile(File file, Class<T> clz, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(mapper));

		Resource resource = fromFile(file, rs);

		return (T) resource.getContents().get(0);
	}
	
	public static <T> T fromFile(File file, Class<T> clz) throws IOException { 
		return fromFile(file, clz, resourceSet);
	}

}
