package org.heavywater.engine;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.heavywater.core.Entity;
import org.heavywater.core.HException;
import org.heavywater.core.IEntityResolver;
import org.heavywater.core.IResolver;
import org.heavywater.util.InstanceFactory;

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
		
		listeners = new ArrayList<Listener>();
		shutdownEventFlag = new EventFlag();
	}
	
	private void start0(){
		logInfo("starting Engine");
		
		// initialize before using
		InstanceFactory.instance(); 
		
		// sanitize engine params
		if (cycleTime == 0){
			throw new HException("cycletime = 0");
		}
		
		// engine has only one step
		step(); 
	
	}
	
	private void wait0() {
		try {
			shutdownEventFlag.await();
			logInfo("stopping Engine");
		} catch (InterruptedException e) {
			throw new HException(e);
		}
	}

	public void start(){
		start0();
		wait0();
	}
	
	public void stop(){
		shutdownEventFlag.signal();
	}
	
	public void start(double secs){
		start0();
		
		int delay = (int) (secs*1000);
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				logInfo("stop signalled to Engine");
				stop();
			}
		}, delay);
		
		logInfo("scheduled Engine shutdown in "+secs+"seconds");
		
		wait0();
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
