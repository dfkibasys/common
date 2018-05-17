package de.dfki.iui.basys.common.emf.jaxrs;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osgi.service.component.annotations.Component;

import de.dfki.iui.basys.common.emf.json.JsonUtils;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class EObjectListMessageBodyReader implements MessageBodyReader<List<EObject>> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		if (genericType instanceof ParameterizedType) {
			Type t = ((ParameterizedType) genericType).getActualTypeArguments()[0];
			return EObject.class.isAssignableFrom((Class<?>)t);
		}
		return false;
	}

	@Override
	public List<EObject> readFrom(Class<List<EObject>> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		Resource resource = JsonUtils.fromStream(entityStream, Resource.class);
		return Arrays.asList(resource.getContents().toArray(new EObject[0]));
	}

}
