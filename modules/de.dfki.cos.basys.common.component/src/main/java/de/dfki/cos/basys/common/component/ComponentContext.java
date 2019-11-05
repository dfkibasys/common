package de.dfki.cos.basys.common.component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.google.common.eventbus.EventBus;

import de.dfki.cos.basys.common.component.manager.ComponentManager;
import de.dfki.cos.basys.common.component.registry.ComponentRegistry;

public class ComponentContext {

	private static ComponentContext staticContext = null;

	public static ComponentContext getStaticContext() {
		if (staticContext == null) {
			staticContext = new ComponentContext();
			staticContext.setEventBus(new EventBus());
			staticContext.setScheduledExecutorService(Executors.newScheduledThreadPool(32));
		}
		return staticContext;
	}

	protected EventBus eventBus;
	protected ScheduledExecutorService scheduledExecutorService;
	protected ComponentRegistry componentRegistry;
	protected ComponentManager componentManager;

	public ComponentContext() {
	}

	public ComponentContext(ComponentContext context) {
		this.eventBus = context.getEventBus();
		this.scheduledExecutorService = context.getScheduledExecutorService();
		this.componentRegistry = context.getComponentRegistry();
		this.componentManager = context.getComponentManager();
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public void setEventBus(EventBus eventBus) {
		this.eventBus = eventBus;
	}

	public ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}

	public void setScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
		this.scheduledExecutorService = scheduledExecutorService;
	}

	public ComponentRegistry getComponentRegistry() {
		return componentRegistry;
	}

	public void setComponentRegistry(ComponentRegistry componentRegistry) {
		this.componentRegistry = componentRegistry;
	}

	public ComponentManager getComponentManager() {
		return componentManager;
	}

	public void setComponentManager(ComponentManager componentManager) {
		this.componentManager = componentManager;
	}

}
