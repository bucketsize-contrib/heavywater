package org.heavywater.event;

import java.util.List;

import org.heavywater.driver.EntityDriver;

public class Engine {
	protected List<Listener> listeners;
	protected List<EntityDriver> timed_drivers;

	public void add(Listener listener) {
		listeners.add(listener);
	}
	
	public void add(EntityDriver timed_driver){
		timed_drivers.add(timed_driver);
	}
	
	public void run(){
		
	}
}
