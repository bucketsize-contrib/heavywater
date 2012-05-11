package org.heavywater.event;

import java.util.Map;

import org.heavywater.entity.Entity;
import org.heavywater.event.Listener;

public class Runner {
	private Map<Listener, Thread> lrunMap;
	private Map<Entity, Thread> erunMap;
	
	void run(final Listener listener){
		Thread lt = new Thread(new Runnable(){
			public void run(){
				listener.listen();
			}
		});
		lt.start();
		lrunMap.put(listener, lt);
	}
	
	void run(final Entity entity){
		Thread et = new Thread(new Runnable(){
			public void run(){
				entity.tick();
			}
		});
		et.start();
		erunMap.put(entity, et);
	}
}
