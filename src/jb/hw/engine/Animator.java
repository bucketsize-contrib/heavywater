package jb.hw.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import jb.hw.core.Entity;


/**
 * Animator serves to periodically animate an Entity by calling the step
 * method on it.
 * There is one Animator for any cycleTime in a registered Entity. * Multiple 
 * entities can be linked to one Animator. 
 * @author jb
 *
 */
public class Animator {
	private Long cycleTime;
	private List<Entity> ensemble;
	private TimerTask task;

	public Animator(double ctime){
		ensemble = new ArrayList<Entity>();
		cycleTime = (long) ctime * 1000;
		task = new TimerTask(){
			public void run(){
				animate();
			}
		};
	}

	public Long getCycleTime() {
		return cycleTime;
	}
	
	public void add(Entity e) {
		ensemble.add(e);	
	}
	
	public void add(List<Entity> el) {
		ensemble = el;	
	}
	
	public TimerTask getTask(){
		return task;
	}

	public void animate(){
		for(Entity entity : ensemble){
			entity.step();
		}
	}
}
