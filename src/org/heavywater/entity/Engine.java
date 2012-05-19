package org.heavywater.entity;

import java.util.ArrayList;
import java.util.List;

import org.heavywater.driver.EngineDriver;
import org.heavywater.event.Listener;
import static org.heavywater.util.LogUtil.*;

public class Engine extends Entity{

	private List<Listener> listeners;
	
	public List<Listener> getListeners() {
		return listeners;
	}

	public Engine(){
		this(new EngineDriver());
	}
	
	public Engine(EngineDriver ed){
		super(ed);
		listeners = new ArrayList<Listener>();
	}
	
	public void add(Listener listener) {
		listeners.add(listener);
	}
		
	public void cycleTime(double t){
		cycleTime = t;
	}
	
	public double getCycleTime(){
		return cycleTime;
	}
	
	public void start(){
		logInfo("starting Engine");
		driver.drive(this);
		
		while(true){}
	}
}
