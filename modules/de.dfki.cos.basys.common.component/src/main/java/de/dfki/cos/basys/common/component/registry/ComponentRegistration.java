package de.dfki.cos.basys.common.component.registry;

import de.dfki.cos.basys.common.component.ComponentInfo;

public interface ComponentRegistration {

	void register() throws ComponentRegistrationException;

	void update() throws ComponentRegistrationException;

	void unregister() throws ComponentRegistrationException;
	
	ComponentInfo getComponentInfo();

}
