package org.heavywater.engine;

import static org.heavywater.util.LogUtil.logInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import org.heavywater.core.Base;
import org.heavywater.core.Entity;

/**
 * Animator serves to periodically animate an Entity by calling the step
 * method on it.
 * There is one Animator for any cycleTime in a registered Entity. * Multiple 
 * entities can be linked to one Animator. 
 * @author jb
 *
 */
public class Animator extends Base{
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
		
		logInfo("added "+e.toString()+" to "+this.toString());
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
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("(Animator id=");
		sb.append(getID());
		sb.append(" ct-ms=");
		sb.append(cycleTime);
		sb.append(" et-count=");
		sb.append(ensemble.size());
		sb.append(")");
		
		return sb.toString();
	}
}
