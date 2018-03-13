package de.dfki.iui.basys.common.scxml.unit;

public interface StatusInterface {

	String getId();

	State getState();
	
	Mode getMode();	

	UnitConfiguration getConfig();
}
