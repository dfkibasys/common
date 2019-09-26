/**
 */
package de.dfki.cos.basys.common.component;

public class ComponentInfo {

	protected String id;
	protected String name;
	protected boolean activated;
	protected boolean connectedToExternal;

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

	public boolean isActivated() {
		return activated;
	}

	public void setActivated(boolean activated) {
		this.activated = activated;
	}

	public boolean isConnectedToExternal() {
		return connectedToExternal;
	}

	public void setConnectedToExternal(boolean connectedToExternal) {
		this.connectedToExternal = connectedToExternal;
	}

	public static class Builder {
		protected String id;
		protected String name;
		protected boolean activated;
		protected boolean connectedToExternal;

		public Builder id(String id) {
			this.id = id;
			return this;
		}

		public Builder name(String name) {
			this.name = name;
			return this;
		}

		public Builder activated(boolean activated) {
			this.activated = activated;
			return this;
		}

		public Builder connectedToExternal(boolean connectedToExternal) {
			this.connectedToExternal = connectedToExternal;
			return this;
		}

		public ComponentInfo build() {
			return new ComponentInfo(this);
		}
	}

	protected ComponentInfo(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.activated = builder.activated;
		this.connectedToExternal = builder.connectedToExternal;
	}
}
