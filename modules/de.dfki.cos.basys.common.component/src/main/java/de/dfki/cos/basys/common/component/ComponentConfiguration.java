/**
 */
package de.dfki.cos.basys.common.component;

import java.util.HashMap;
import java.util.Map;

public class ComponentConfiguration {
	String id;
	String name;
	String externalConnectionString;
	String implementationJavaClass;
	Map<String, String> properties = new HashMap<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExternalConnectionString() {
		return externalConnectionString;
	}

	public void setExternalConnectionString(String externalConnectionString) {
		this.externalConnectionString = externalConnectionString;
	}

	public String getImplementationJavaClass() {
		return implementationJavaClass;
	}

	public void setImplementationJavaClass(String implementationJavaClass) {
		this.implementationJavaClass = implementationJavaClass;
	}

	public Map<String, String> getProperties() {
		return properties;
	}

	public static class Builder {
		private String id;
		private String name;
		private String externalConnectionString;
		private String implementationJavaClass;
		private Map<String, String> properties = new HashMap<>();

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder externalConnectionString(String externalConnectionString) {
			this.externalConnectionString = externalConnectionString;
			return this;
		}

		public Builder implementationJavaClass(String implementationJavaClass) {
			this.implementationJavaClass = implementationJavaClass;
			return this;
		}

		public Builder addProperty(String key, String value) {
			this.properties.put(key, value);
			return this;
		}

		public ComponentConfiguration build() {
			return new ComponentConfiguration(this);
		}
	}

	private ComponentConfiguration(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.externalConnectionString = builder.externalConnectionString;
		this.implementationJavaClass = builder.implementationJavaClass;
		this.properties = builder.properties;
	}
}
