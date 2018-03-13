package de.dfki.iui.basys.common.scxml.unit;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.dfki.iui.basys.common.scxml.TestHandler;

public class PackML {

	protected final Logger LOGGER = LoggerFactory.getLogger(PackML.class.getName());
		
	private Mode mode = Mode.PRODUCTION;

	private PackMLUnit unit = null;

	private boolean initialized = false;

	private SCXML scxml = null;
	private SCXMLExecutor exec = null;
	///////////////////////////////

	public PackML(PackMLUnit unit) {
		this.unit = unit;
	}

	public void initialize() {
		if (!initialized) {
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
				exec.getRootContext().set("unit", unit);
				exec.getRootContext().set("Mode", Mode.class);

				exec.go();

				initialized = true;
			} catch (IOException | ModelException | XMLStreamException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void dispose() {
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

	public void setMode(Mode mode){
		State state = getState();
		if (mode == Mode.MANUAL && state == State.ABORTED) {
			this.mode = mode;
		} else if (state == State.STOPPED) {
			this.mode = mode;
		} else {
			// illegal state
			LOGGER.warn("Cannot change mode in state " + state);
		}
	}

	public void raiseLifecycleEvent(String event) {
		try {
			exec.triggerEvent(new EventBuilder("lifecycle.events." + event, TriggerEvent.SIGNAL_EVENT).build());
		} catch (ModelException e) {
			e.printStackTrace();
		}
	}

}
