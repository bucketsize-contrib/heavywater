package org.heavywater.event;

import java.util.List;

import org.heavywater.entity.Entity;

public class Engine extends Entity{
	private double cycleTime;

	private  List<Listener> listeners;
	
	public List<Listener> getListeners() {
		return listeners;
	}

	public Engine(EngineDriver ed){
		super(ed);
	}
	
	public void add(Listener listener) {
		listeners.add(listener);
	}
		
	public void cycleTime(long t){
		cycleTime = t;
	}
	
	public double getCycleTime(){
		return cycleTime;
	}
	
	public void start(){
		driver.drive(this);
	}
}
