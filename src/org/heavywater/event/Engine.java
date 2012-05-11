package org.heavywater.event;

import java.util.List;

import org.heavywater.driver.EntityDriver;
import org.heavywater.entity.Entity;

public class Engine {
	protected List<Listener> listeners;
	protected List<Entity> entities;
	protected long cycleTime;

	public void add(Listener listener) {
		listeners.add(listener);
	}
	
	public void add(Entity entity){
		entities.add(entity);
	}
	
	public void cycleTime(long t){
		cycleTime = t;
	}
	
	public void run(){
		
	}
}
