package de.dfki.cos.basys.common.component.manager;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public interface ComponentConfigurationProvider {
	List<String> getComponentConfigurationPaths();
	Properties getComponentConfiguration(String path);
}
