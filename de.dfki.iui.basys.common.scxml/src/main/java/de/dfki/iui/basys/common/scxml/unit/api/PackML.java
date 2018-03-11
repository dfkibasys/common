package de.dfki.iui.basys.common.scxml.unit.api;

import java.io.IOException;
import java.net.URL;

import javax.xml.stream.XMLStreamException;

import org.apache.commons.scxml2.EventBuilder;
import org.apache.commons.scxml2.SCXMLExecutor;
import org.apache.commons.scxml2.TriggerEvent;
import org.apache.commons.scxml2.env.SimpleDispatcher;
import org.apache.commons.scxml2.env.SimpleSCXMLListener;
import org.apache.commons.scxml2.env.jexl.JexlEvaluator;
import org.apache.commons.scxml2.io.SCXMLReader;
import org.apache.commons.scxml2.model.EnterableState;
import org.apache.commons.scxml2.model.ModelException;
import org.apache.commons.scxml2.model.SCXML;

import de.dfki.iui.basys.common.scxml.unit.api.Unit.Mode;
import de.dfki.iui.basys.common.scxml.unit.api.Unit.State;

public class PackML {

	Mode mode;

	ActiveStatesHandler handler = null;

	boolean initialized = false;

	protected SCXML scxml = null;
	protected SCXMLExecutor exec = null;
	///////////////////////////////

	public PackML(ActiveStatesHandler handler) {
		this.handler = handler;
	}
	
	protected void initialize() {
		if (!initialized && handler != null) {
			URL scxmlResource = this.getClass().getResource("/packml.scxml");
			// initialize states and state machine
			try {
				scxml = SCXMLReader.read(scxmlResource);

				// configure state machine and set loaded scxml
				exec = new SCXMLExecutor();
				exec.setEvaluator(new JexlEvaluator());
				exec.setStateMachine(scxml);
				exec.setEventdispatcher(new SimpleDispatcher());

				// add script variables to scope
				exec.addListener(scxml, new SimpleSCXMLListener());
				exec.getRootContext().set("unit", handler);

				exec.go();

				initialized = true;
			} catch (IOException | ModelException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	protected void dispose() {
		if (initialized) {
			initialized = false;
		}
	}

	public State getState() {
		EnterableState state = exec.getStatus().getStates().toArray(new EnterableState[0])[0];
		State result = State.valueOf(state.getId());
		return result;
	}

	public Mode getMode() {
		return mode;
	}

	public void changeMode(Mode mode) {
		// this.mode = mode;
	}

	protected void raiseLifecycleEvent(String event) {
		try {
			exec.triggerEvent(new EventBuilder("lifecycle.events." + event, TriggerEvent.SIGNAL_EVENT).build());
		} catch (ModelException e) {
			e.printStackTrace();
		}
	}

}
