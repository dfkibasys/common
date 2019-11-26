package de.dfki.cos.basys.common.component.manager.impl;

import de.dfki.cos.basys.common.component.Component;

public class ComponentManagerEvent {
	public enum Type {
		CONFIG_FILE_CREATED,
		CONFIG_FILE_DELETED,
		COMPONENT_ADDED,
		COMPONENT_DELETED
	};
	
	public Type type;
	public String value;
	public Component component;
	
	public ComponentManagerEvent(Type type, String value) {
		this.type = type;
		this.value = value;
	}
	
	public ComponentManagerEvent(Type type, String value, Component component) {
		this.type = type;
		this.value = value;
		this.component = component;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getValue() {
		return value;
	}

	public Component getComponent() {
		return component;
	}
	
	@Override
	public String toString() {
		return "ComponentManagerEvent [type=" + type + ", value=" + value + "]";
	}
	
	
}
