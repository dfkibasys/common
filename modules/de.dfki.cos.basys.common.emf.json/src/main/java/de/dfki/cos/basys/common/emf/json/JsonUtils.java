package de.dfki.cos.basys.common.emf.json;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Consumer;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.emfjson.jackson.annotations.EcoreReferenceInfo;
import org.emfjson.jackson.annotations.EcoreTypeInfo;
import org.emfjson.jackson.databind.EMFContext;
import org.emfjson.jackson.module.EMFModule;
import org.emfjson.jackson.resource.JsonResourceFactory;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import de.dfki.cos.basys.common.emf.EmfUtils;

public class JsonUtils {

	public static EMFModule defaultModule;
	public static EMFModule customModule;
	public static ObjectMapper defaultMapper;
	public static ObjectMapper customMapper;
	public static ResourceSetFactory factory  = new ResourceSetFactory() {		
		@Override
		public ResourceSet createResourceSet() {
			return new ResourceSetImpl();
		}
	};

	static {
		// same as emf
		final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getDefault());
		
		defaultModule = new EMFModule();	
		defaultModule.setTypeInfo(new EcoreTypeInfo());
		defaultModule.setReferenceInfo(new EcoreReferenceInfo(new MyURIHandler("http://localhost:8080/services/entity")));	
		defaultModule.setReferenceSerializer(MyEcoreReferenceSerializer.from(defaultModule, false));
		
		defaultMapper = new ObjectMapper(null);		
		defaultMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		defaultMapper.setDateFormat(dateFormat);
		defaultMapper.setTimeZone(TimeZone.getDefault());
		defaultMapper.registerModule(defaultModule);	
		
		customModule = new EMFModule();		
		customModule.setTypeInfo(new EcoreTypeInfo());
		customModule.setReferenceInfo(new EcoreReferenceInfo(new MyURIHandler("http://localhost:8080/services/entity")));		
		customModule.setReferenceSerializer(MyEcoreReferenceSerializer.from(customModule, true));
//		customModule.setReferenceDeserializer(new MyEcoreReferenceDeserializer(customModule.getReferenceInfo(), customModule.getTypeInfo()));
		
		customMapper = new ObjectMapper(null);
		customMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		customMapper.setDateFormat(dateFormat);
		customMapper.setTimeZone(TimeZone.getDefault());
		customMapper.registerModule(customModule);	
		
		//resourceSet = new BasysResourceSetImpl();
		//resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));
	}

	private static ObjectMapper selectMapper(boolean custom) {
		if (custom) {
			return customMapper;
		} 
		return defaultMapper;
	}
	
	public static void toStream(OutputStream os, EObject entity, boolean resolveReferences) throws JsonGenerationException, JsonMappingException, IOException {
		
		EObject toSerialize;
		//if (resolveReferences) {
			//normal cloning
			toSerialize = EcoreUtil.copy(entity);
		//} else {
			//includes bi-directional references -> role in resourceinstance
		//	toSerialize = EmfUtils.clone(entity);
		//}
		
		//this should always be the case, just for debugging
		if (toSerialize.eResource() == null) {
			ResourceSet resourceSet = factory.createResourceSet();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));
			Resource resource = resourceSet.createResource(URI.createURI(System.currentTimeMillis() + ".json"));
			resource.getContents().add(toSerialize);
		}
		
		if (resolveReferences) {
			EcoreUtil.resolveAll(toSerialize);
		}
		
		selectMapper(resolveReferences).writeValue(os, toSerialize.eResource());
		
//		Resource originalResource = entity.eResource();
//		
//		
//		EObject container = entity.eContainer();
//		EReference ref = entity.eContainmentFeature();
//		EStructuralFeature str = entity.eContainingFeature();
//		
//		ResourceSet resourceSet = factory.createResourceSet();
//		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));
//		Resource resource = resourceSet.createResource(URI.createURI(System.currentTimeMillis() + ".json"));
//				
//		if (resolveReferences) {
//			EcoreUtil.resolveAll(entity);
//		}
//		resource.getContents().add(entity);
//		
//		selectMapper(resolveReferences).writeValue(os, resource);
//					
//		if (originalResource != null) {
//			if (container != null) {
//				if (str.isMany()) {
//					EList<Object> list = (EList<Object>) container.eGet(str);
//					list.add(entity);
//				} else {
//					container.eSet(str, entity);
//				}
//			} else {
//				originalResource.getContents().add(entity);
//			}
//		}
		
		
		
		
		
//		String result = selectMapper(resolveReferences).writeValueAsString(entity);
//		String content = toString(entity, resolveReferences);
//		
//		ResourceSet resourceSet = new BasysResourceSetImpl();
//		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("json", new JsonResourceFactory());
//		Resource resource = resourceSet.createResource(URI.createURI(System.currentTimeMillis() + ".json"));
//		//if (entity.eResource() != null)
//			resource.getContents().add(EmfUtils.clone(entity));
//		//else
//		//	resource.getContents().add(entity);
//			
//		
//		selectMapper(resolveReferences).writeValue(os, resource);
	}
	
	public static void toStream(OutputStream os, EObject entity) throws JsonGenerationException, JsonMappingException, IOException {
		toStream(os, entity, false);
	}
	
	public static void toStream(OutputStream os, Collection<? extends EObject> entities, boolean resolveReferences) throws IOException {
		ResourceSet resourceSet = factory.createResourceSet();
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));
		Resource resource = resourceSet.createResource(URI.createURI(System.currentTimeMillis() + ".json"));
		
		entities.forEach(new Consumer<EObject>() {
			@Override
			public void accept(EObject entity) {
				EObject toSerialize = EmfUtils.clone(entity);
				if (resolveReferences) {
					EcoreUtil.resolveAll(toSerialize);
				}
				resource.getContents().add(toSerialize);				
			}
		});
		
		selectMapper(resolveReferences).writeValue(os, entities);

	}

	public static void toStream(OutputStream os, Collection<? extends EObject> entities) throws IOException {
		toStream(os, entities, false);
	}
	
	public static String toString(EObject entity, boolean resolveReferences) throws JsonProcessingException {
		EObject toSerialize = EmfUtils.clone(entity);
		
		//this should always be the case, just for debugging
		if (toSerialize.eResource() == null) {
			ResourceSet resourceSet = factory.createResourceSet();
			resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));
			Resource resource = resourceSet.createResource(URI.createURI(System.currentTimeMillis() + ".json"));
			resource.getContents().add(toSerialize);
		}
		
		if (resolveReferences) {
			EcoreUtil.resolveAll(toSerialize);
		}
		String result = selectMapper(resolveReferences).writeValueAsString(toSerialize.eResource());
		return result;
	}
	
	public static String toString(EObject entity) throws JsonProcessingException {
		return toString(entity, false);
	}

	public static Resource fromStream(InputStream input, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));

		Resource resource = customMapper
				.reader()
				.withAttribute(EMFContext.Attributes.RESOURCE_SET, rs)
				.withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI(System.currentTimeMillis() + ".json"))
				.forType(Resource.class)
				.readValue(input);

		return resource;
	}
	
	public static Resource fromStream(InputStream input) throws IOException {
		return fromStream(input, factory.createResourceSet());
	}
	
	public static <T> T fromStream(InputStream input, Class<T> clz, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));

		Resource resource = fromStream(input, rs);

		return (T) resource.getContents().get(0);
	}
	
	public static <T> T fromStream(InputStream input, Class<T> clz) throws IOException { 
		return fromStream(input, clz, factory.createResourceSet());
	}
	
	public static Resource fromString(String input, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));

		Resource resource = customMapper
				.reader()
				.withAttribute(EMFContext.Attributes.RESOURCE_SET, rs)
				.withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI(System.currentTimeMillis() + ".json"))
				.forType(Resource.class)
				.readValue(input);

		return resource;
	}
	
	public static Resource fromString(String input) throws IOException {
		return fromString(input, factory.createResourceSet());
	}
	
	public static <T> T fromString(String input, Class<T> clz, ResourceSet rs) throws IOException {
		//rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));

		Resource resource = fromString(input, rs);

		return (T) resource.getContents().get(0);
	}
	
	public synchronized static <T> T fromString(String input, Class<T> clz) throws IOException { 
		return fromString(input, clz, factory.createResourceSet());
	}
	

	public static Resource fromFile(File file, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));

		Resource resource = customMapper
				.reader()
				.withAttribute(EMFContext.Attributes.RESOURCE_SET, rs)
				.withAttribute(EMFContext.Attributes.RESOURCE_URI, URI.createURI(System.currentTimeMillis() + ".json"))
				.forType(Resource.class)
				.readValue(file);

		return resource;
	}
	
	public static Resource fromFile(File file) throws IOException {
		return fromFile(file, factory.createResourceSet());
	}
	
	public static <T> T fromFile(File file, Class<T> clz, ResourceSet rs) throws IOException {
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("json", new JsonResourceFactory(customMapper));

		Resource resource = fromFile(file, rs);

		return (T) resource.getContents().get(0);
	}
	
	public static <T> T fromFile(File file, Class<T> clz) throws IOException { 
		return fromFile(file, clz, factory.createResourceSet());
	}

}
