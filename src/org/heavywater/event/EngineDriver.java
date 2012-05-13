package org.heavywater.event;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.heavywater.driver.EntityDriver;
import org.heavywater.entity.Entity;

public class EngineDriver extends EntityDriver{
	private Map<Listener, Thread> lrunMap;
	private HashMap<Entity, TimerTask> erunMap;
	Timer timer;
	
	public EngineDriver(){
		System.out.println("[II] init EngineDriver");
		lrunMap = new HashMap<Listener, Thread>();
		erunMap = new HashMap<Entity, TimerTask>();
		timer = new Timer();
	}
	
	void run(final Listener listener){
		Thread lt = new Thread(new Runnable(){
			public void run(){
				listener.listen();
			}
		});
		lt.start();
		lrunMap.put(listener, lt);
	}
	
	void run(final Entity entity, double withDelay){
		TimerTask tta = new TimerTask(){
			public void run(){
				entity.tick();
			}
		};
		
		timer.scheduleAtFixedRate(tta, 100, 1000);
		
		erunMap.put(entity, tta);
	}

	public void drive(Entity e) {
		Engine engine = (Engine) e;
		for (Entity en : engine.getEnsemble()){
			System.out.println("[II] starting new monitor for Entity");
			run(en, engine.getCycleTime());
		}
		for (Listener lnr : engine.getListeners()){
			System.out.println("[II] starting Listener");
			run(lnr);
		}
	}
}
