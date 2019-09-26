package de.dfki.cos.basys.common.component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.google.common.eventbus.EventBus;

public class ComponentContext {

	private static ComponentContext staticContext = null;
	
	public static ComponentContext getStaticContext() {
		if (staticContext == null) {
			staticContext = new Builder().eventBus(new EventBus()).scheduledExecutorService(Executors.newScheduledThreadPool(32)).build();
		}
		return staticContext;
	}
	
	private EventBus eventBus;
	private ScheduledExecutorService scheduledExecutorService;

	public EventBus getEventBus() {
		return eventBus;
	}

	public ScheduledExecutorService getScheduledExecutorService() {
		return scheduledExecutorService;
	}

	public static class Builder {
		private EventBus eventBus;
		private ScheduledExecutorService scheduledExecutorService;

		public Builder eventBus(EventBus eventBus) {
			this.eventBus = eventBus;
			return this;
		}

		public Builder scheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
			this.scheduledExecutorService = scheduledExecutorService;
			return this;
		}

		public ComponentContext build() {
			return new ComponentContext(this);
		}
	}

	private ComponentContext(Builder builder) {
		this.eventBus = builder.eventBus;
		this.scheduledExecutorService = builder.scheduledExecutorService;
	}
}
