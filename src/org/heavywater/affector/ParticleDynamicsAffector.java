package org.heavywater.affector;

import static org.heavywater.util.LogUtil.logInfo;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;
import org.heavywater.util.prNotation;

public class ParticleDynamicsAffector extends Affector{
	private static Object ins;
	
	public static Object instance(){
		return ins!=null?ins:(ins=create());
	}
	
	private static Object create(){
		return new ParticleDynamicsAffector();
	}
	public ParticleDynamicsAffector(){
		logInfo("new "+this);
	}
	public void affect(Property p, Entity e) {
		Dynamics d = (Dynamics) p;

		Vector3 a = d.accel;
		Vector3 v = d.velocity; 
		double t = e.getCycleTime();

		// s = s + ( v*t + 0.5*a*t^2 )
		d.location = d.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  

		// v = v + at
		d.velocity = v.add( a.mult(t) );

		logInfo("Particle "+e.getID()+"="+prNotation.generate(d));
		logInfo("aliveTime= " + e.getAliveTime());
	}

}
