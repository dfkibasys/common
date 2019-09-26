package de.dfki.cos.basys.common.component.util;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;

import de.dfki.cos.basys.common.component.ComponentContext;
import de.dfki.cos.basys.common.component.ComponentInfo;

public class ComponentInfoRecorder {

	private LinkedBlockingQueue<ComponentInfo> infos = new LinkedBlockingQueue<>();

	public ComponentInfoRecorder() {
		ComponentContext.getStaticContext().getEventBus().register(this);
	}
	
	public ComponentInfoRecorder(ComponentContext context) {
		context.getEventBus().register(this);
	}
	
	@Subscribe
	private void notifyComponentInfo(ComponentInfo info) {
		infos.add(info);
	}

	public LinkedBlockingQueue<ComponentInfo> getInfos() {
		return infos;
	}

	public ComponentInfo getLastInfo() {
		try {
			return infos.poll(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public void clear() {
		infos.clear();
	}
	
}
