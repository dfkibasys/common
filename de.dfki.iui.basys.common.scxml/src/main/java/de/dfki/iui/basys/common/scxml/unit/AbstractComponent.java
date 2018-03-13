package de.dfki.iui.basys.common.scxml.unit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractComponent implements ActiveStatesHandler, WaitStatesHandler {
	
	protected final Logger LOGGER = LoggerFactory.getLogger(AbstractComponent.class.getName());
	
	protected PackMLUnit unit;
	
	public AbstractComponent(String id) {
		unit = new PackMLUnit(id);
		unit.setActiveStatesHandler(this);
		unit.setWaitStatesHandler(this);
	}
	
	public void initialize() {
		unit.initialize();
		//register service
	}

	public void dispose() {
		//unregister service
		unit.dispose();
	}

	//TODO: Code for communicating with the Basys Middleware: process incoming requests, notify task completion and errors back
	

	/*
	 * default WaitStatesHandler implementation -> notify Basys Middleware
	 */
	
	@Override
	public void onStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onIdle() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onComplete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuspend() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAborted() {
		// TODO Auto-generated method stub
		
	}

}
