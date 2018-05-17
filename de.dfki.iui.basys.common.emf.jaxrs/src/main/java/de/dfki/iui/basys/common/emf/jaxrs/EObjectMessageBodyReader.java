package de.dfki.iui.basys.common.emf.jaxrs;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;

import org.eclipse.emf.ecore.EObject;
import org.osgi.service.component.annotations.Component;

import de.dfki.iui.basys.common.emf.json.JsonUtils;

@Provider
@Consumes(MediaType.APPLICATION_JSON)
@Component
public class EObjectMessageBodyReader implements MessageBodyReader<EObject> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return EObject.class.isAssignableFrom(type);
	}

	@Override
	public EObject readFrom(Class<EObject> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws WebApplicationException {

		try {
			// String json = Utils.getStringFromInputStream(entityStream);
			// System.out.println(json);
			EObject result = JsonUtils.fromStream(entityStream, EObject.class);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
