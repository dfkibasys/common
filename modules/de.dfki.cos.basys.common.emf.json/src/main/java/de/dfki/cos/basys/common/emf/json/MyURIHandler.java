package de.dfki.cos.basys.common.emf.json;

import org.eclipse.emf.common.util.URI;
import org.emfjson.jackson.handlers.BaseURIHandler;

public class MyURIHandler extends BaseURIHandler {

	String baseUri = null;
	
	public MyURIHandler(String baseUri) {
		this.baseUri = baseUri; 
	}
	
	@Override
	public URI deresolve(URI baseURI, URI uri) {
		
		if (uri.toString().contains("//"))
				return uri;
			
		// return super.deresolve(arg0, arg1);
		if (resolve(baseURI) && !uri.isRelative()) {
			URI deresolvedURI = uri.deresolve(baseURI, true, true, false);
			if (deresolvedURI.hasRelativePath()) {
				uri = deresolvedURI;
			}
		} else {
			if (uri.hasFragment()) {
				String fragment = uri.fragment();
				uri = URI.createURI(baseUri);
				uri = uri.appendSegment(fragment);
			}
		}
		return uri;
	}

}
