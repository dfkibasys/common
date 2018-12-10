package de.dfki.cos.basys.common.emf.jaxrs;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.eclipse.emf.ecore.EObject;
import org.osgi.service.component.annotations.Component;

import de.dfki.cos.basys.common.emf.json.JsonUtils;

@Provider
@Produces(MediaType.APPLICATION_JSON)
@Component(immediate=true)
public class EObjectListMessageBodyWriter implements MessageBodyWriter<List<EObject>> {

	@Context
	HttpHeaders httpRequestHeaders;

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		if (genericType instanceof ParameterizedType) {
			Type t = ((ParameterizedType) genericType).getActualTypeArguments()[0];
			return EObject.class.isAssignableFrom((Class<?>)t);
		}
		return true;
	}

	@Override
	public long getSize(List<EObject> entities, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return -1;
	}

	@Override
	public void writeTo(List<EObject> entities, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		MultivaluedMap<String,String> headers = httpRequestHeaders.getRequestHeaders();
		List<String> resolve = httpRequestHeaders.getRequestHeader("X-BaSys-Resolve");
		if (resolve != null && resolve.get(0).equals("true")) {
			JsonUtils.toStream(entityStream, entities, true);
		} else {
			JsonUtils.toStream(entityStream, entities, false);
		}	
	}

}
