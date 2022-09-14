package de.dfki.cos.basys.common.emf.jaxrs.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class Activator implements BundleActivator {

	  private ServiceRegistration registration;

	  @Override
	  public void start( BundleContext bundleContext ) throws Exception {
		  JacksonJsonProvider provider = new JacksonJsonProvider();		  
		  registration = bundleContext.registerService(JacksonJsonProvider.class.getName(), provider, null );
	  }

	  @Override
	  public void stop( BundleContext bundleContext ) throws Exception {
	    if( registration != null ) {
	      registration.unregister();
	    }
	  }
	}
