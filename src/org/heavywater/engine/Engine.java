package org.heavywater.engine;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.ArrayList;
import java.util.List;

import org.heavywater.core.Entity;
import org.heavywater.core.HException;
import org.heavywater.core.IEntityResolver;
import org.heavywater.core.IResolver;

/**
 * Engine is an Entity that entangles cause and effects of Entities over a 
 * region of space.
 * 
 * It does this by managing Animators and Listeners for Entities.
 * The management is delegated to the EngineDriver, which can cause different
 * implementations.
 */
public class Engine extends Entity{

	private boolean ENGINE_STARTED = false;
	private List<Listener> listeners;
	EventFlag shutdownEventFlag;

	public Engine(EngineDriver ed){
		super(ed);
		cycleTime=1.0;
		
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
		if (cycleTime == 0){
			throw new HException("engine::cycletime = 0");
		}
		
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

	public Object dispatch(IEntityResolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Engine ");
		sb.append(getID());
		sb.append(" ");
		sb.append(getCycleTime());
		sb.append(" ");
		sb.append(getAliveTime());
		sb.append(" ");
		sb.append(getListeners().size());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IEntityResolver) r).resolve(this);
	}

}
