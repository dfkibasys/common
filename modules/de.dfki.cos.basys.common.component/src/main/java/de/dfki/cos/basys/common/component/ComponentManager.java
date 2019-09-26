/**
 */
package de.dfki.cos.basys.common.component;

import java.io.File;
import java.util.List;

public interface ComponentManager extends Component {
	
	List<Component> getComponents();
	Component getComponentById(String id);
	Component getComponentByName(String name);

	Component createComponent(ComponentConfiguration config) throws ComponentManagerException;
	Component createComponent(File configFile) throws ComponentManagerException;
	void createComponents(File configFolder, boolean recursive) throws ComponentManagerException;
	void addComponent(Component component) throws ComponentManagerException;
	void deleteComponent(String id) throws ComponentManagerException;

}
