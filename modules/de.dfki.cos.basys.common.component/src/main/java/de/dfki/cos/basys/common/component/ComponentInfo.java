/**
 */
package de.dfki.cos.basys.common.component;

import java.util.Properties;

public class ComponentInfo extends Properties {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ComponentInfo() {
	}
	
	public ComponentInfo(Properties p) {
		super(p);
		//this.putAll(p);
	}
	
	public String getId() {
		return getProperty(StringConstants.id);
	}

	public <T extends ComponentInfo> T setId(String id) {
		setProperty(StringConstants.id, id);
		return (T) this;
	}

	public String getName() {
		return getProperty(StringConstants.name);
	}

	public <T extends ComponentInfo> T setName(String name) {
		setProperty(StringConstants.name, name);
		return (T) this;
	}
	
	public String getCategory() {
		return getProperty(StringConstants.category);
	}

	public <T extends ComponentInfo> T setCategory(String category) {
		setProperty(StringConstants.category, category);
		return (T) this;
	}

	public boolean isActivated() {
		return Boolean.parseBoolean(getProperty(StringConstants.activated));
	}

	public <T extends ComponentInfo> T setActivated(Boolean value) {
		setProperty(StringConstants.activated, value.toString());
		return (T) this;
	}
	
	public boolean isConnected() {
		return Boolean.parseBoolean(getProperty(StringConstants.connected));
	}

	public <T extends ComponentInfo> T setConnected(Boolean value) {
		setProperty(StringConstants.connected, value.toString());
		return (T) this;
	}

}
