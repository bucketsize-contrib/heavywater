package org.heavywater.entity;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.ArrayList;
import java.util.List;

import org.heavywater.driver.EngineDriver;
import org.heavywater.event.EventFlag;
import org.heavywater.event.Listener;
import org.heavywater.ex.*;

public class Engine extends Entity{

	private boolean ENGINE_STARTED = false;
	private List<Listener> listeners;
	EventFlag shutdownEventFlag;

	public Engine(){
		this(new EngineDriver());
	}
	
	public Engine(EngineDriver ed){
		super(ed);
		cycleTime=1.0; // default, override
		listeners = new ArrayList<Listener>();
		shutdownEventFlag = new EventFlag();
	}
	
	public void add(Listener l) {
		listeners.add(l);
	}
	
	public List<Listener> getListeners() {
		return listeners;
	}
	
	public void step(){
		if (!ENGINE_STARTED){
			ENGINE_STARTED=true;
			super.step();
		}
	}
	
	public void start(){
		logInfo("starting Engine");
		
		// sanitize engine params
		if (cycleTime == 0)
			throw new HWException("engine::cycletime = 0");
		
		// engine has only one step
		step(); 
		
		// shutdown after step is completed
		try {
			shutdownEventFlag.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void halt(){
		shutdownEventFlag.signal();
	}
}
