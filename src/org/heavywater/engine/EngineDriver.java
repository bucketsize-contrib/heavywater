package org.heavywater.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;

import org.heavywater.core.Entity;
import org.heavywater.core.EntityDriver;

import static org.heavywater.util.LogUtil.*;

/**
 * Specialized Driver only for Engine
 *
 */
public class EngineDriver extends EntityDriver{
	private Map<Listener, Thread> listenerMap;
	private Map<Long, Animator> animatorMap;
	Timer timer;
	
	public EngineDriver(){
		logInfo("init EngineDriver");
		listenerMap = new HashMap<Listener, Thread>();
		animatorMap = new HashMap<Long, Animator>();
		timer = new Timer();
	}
	
	void start(final Listener listener){
		Thread lt = new Thread(new Runnable(){
			public void run(){
				listener.listen();
			}
		});
		lt.start();
		listenerMap.put(listener, lt);
	}
	
	void start(final Entity e){		
		Long eKey = (long) (e.getCycleTime()*1000);
		Animator a;
		
		// get an Animator, else create a new one
		if (animatorMap.containsKey(eKey)){
			a = animatorMap.get(eKey);
		}else{
			a = new Animator(eKey);
			animatorMap.put(eKey, a);
			timer.scheduleAtFixedRate(a.getTask(), 100, eKey);
		}
		
		// register Entity with the Animator
		a.add(e);		
	}

	public void drive(Entity e) {
		Engine engine = (Engine) e;
		
		logInfo("starting Entity animators");
		for(Entity en: e.getEnsemble()){
			start(en);
		}		

		logInfo("starting Entity listeners");
		for (Listener lnr : engine.getListeners()){
			start(lnr);
		}
	}
}
