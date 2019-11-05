package de.dfki.cos.basys.common.component.registry;

import de.dfki.cos.basys.common.component.ComponentInfo;

public interface ComponentRegistryObserver {

	ComponentInfo getComponentInfo(String componentId);
	
	void handleComponentAdded(ComponentInfo info);

	void handleComponentUpdated(ComponentInfo info);

	void handleComponentRemoved(ComponentInfo info);
}
