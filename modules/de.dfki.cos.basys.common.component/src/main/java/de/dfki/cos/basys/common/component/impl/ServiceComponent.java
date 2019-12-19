package de.dfki.cos.basys.common.component.impl;

import java.util.Objects;
import java.util.Properties;
import java.util.function.Supplier;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentException;
import de.dfki.cos.basys.common.component.ComponentInfo;
import de.dfki.cos.basys.common.component.ServiceProvider;
import de.dfki.cos.basys.common.component.StringConstants;
import de.dfki.cos.basys.common.component.ServiceManager;

public class ServiceComponent<T> extends BaseComponent {


	protected ServiceManager<T> serviceManager = null;
	
	public ServiceComponent(Properties config) {
		super(config);
		
		if ( config.getProperty(StringConstants.serviceImplementationJavaClass) != null) {
			serviceManager = new ServiceManagerImpl<T>(config);
		}
	}
	
	public ServiceComponent(Properties config, ServiceProvider<T> serviceProvider) {
		super(config);

		serviceManager = new ServiceManagerImpl<T>(config, serviceProvider);
	}
	
	public ServiceComponent(Properties config, Supplier<ServiceProvider<T>> serviceProviderSupplier) {
		super(config);

		serviceManager = new ServiceManagerImpl<T>(config, serviceProviderSupplier.get());
	}


	// @Override
	public ServiceManager<T> getServiceManager() {
		return serviceManager;
	}

	// @Override
	public T getService() {
		return serviceManager.getService();
	}

	@Override
	public void activate(ComponentContext context) throws ComponentException {
		if (!isActivated()) {
			if (serviceManager != null) {
//				if (serviceManager.getServiceMockup() != null) {
//					configureServiceMockup(serviceManager.getServiceMockup());
//				}
				serviceManager.connect(context);
			}
			super.activate(context);
		}
	}
	
	
	@Override
	public void deactivate() throws ComponentException {
		if (isActivated()) { 
			super.deactivate();
			if (serviceManager != null)
				serviceManager.disconnect();
		}
	}
	

	public boolean isConnected() {
		return (serviceManager != null) ? serviceManager.isConnected() : false;
	}
	
	protected void configureServiceMockup(T serviceMockup) {
		
	};

	public ComponentInfo getInfo() {
		ComponentInfo info = super.getInfo();
		info.setConnected(isConnected());
		return info;
	}
	
	
	// @Override
//	public T getService(Class<T> serviceInterface) {
//		return serviceInterface.cast(serviceManager.getServiceInterface());
//	}
	
}
