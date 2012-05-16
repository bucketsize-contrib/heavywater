package org.heavywater.driver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Entity;
import org.heavywater.event.Animator;
import org.heavywater.event.Listener;

public class EngineDriver extends EntityDriver{
	private Map<Listener, Thread> lrunMap;
	private Map<Long, Animator> erunMap;
	Timer timer;
	
	public EngineDriver(){
		System.out.println("[II] init EngineDriver");
		lrunMap = new HashMap<Listener, Thread>();
		erunMap = new HashMap<Long, Animator>();
		timer = new Timer();
	}
	
	void run(final Listener listener){
		System.out.println("[II] starting Listener");
		Thread lt = new Thread(new Runnable(){
			public void run(){
				listener.listen();
			}
		});
		lt.start();
		lrunMap.put(listener, lt);
	}
	
	void run(final List<Entity> entities, double withDelay){		
		System.out.println("[II] starting Animators");
		for(Entity e: entities){
			Long eKey = (long) (e.getCycleTime()*1000);
			Animator a;
			if (erunMap.containsKey(eKey)){
				a = erunMap.get(eKey);
			}else{
				a = new Animator(eKey);
				erunMap.put(eKey, a);
			}
			a.add(e);
			timer.scheduleAtFixedRate(a.getTask(), 100, eKey);
		}
	}

	public void drive(Entity e) {
		Engine engine = (Engine) e;
		
		run(e.getEnsemble(), engine.getCycleTime());

		for (Listener lnr : engine.getListeners()){
			run(lnr);
		}
	}
}
