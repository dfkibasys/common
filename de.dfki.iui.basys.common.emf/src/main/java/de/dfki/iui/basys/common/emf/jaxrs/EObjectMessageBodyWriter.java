package de.dfki.iui.basys.common.emf.jaxrs;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

import org.eclipse.emf.ecore.EObject;

import de.dfki.iui.basys.common.emf.JsonUtils;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class EObjectMessageBodyWriter implements MessageBodyWriter<EObject> {

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return EObject.class.isAssignableFrom(type);
	}

	@Override
	public long getSize(EObject enitity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediatype) {
		return -1;
	}

	@Override
	public void writeTo(EObject entity, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream)
			throws IOException, WebApplicationException {
		JsonUtils.toStream(entityStream, entity);
	}
}
