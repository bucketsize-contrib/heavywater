package org.heavywater.affector;

import static org.heavywater.util.LogUtil.logInfo;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Kinetics;
import org.heavywater.property.Property;
import org.heavywater.util.Singleton;

// compute kinematics from secondary
// there can be one or more secondary, depends on the affector scheme
// single: when all tertiaries coalesce to one one secondary
// multiple: when there can be a secondary per tertiary
public class ParticleKineticsAffector extends Affector{
	//
	private static Object ins;	
	public static Object instance(){
		return ins!=null?ins:(ins=new ParticleKineticsAffector());
	}
	//
	public ParticleKineticsAffector(){
		logInfo("new "+this);
	}
	
	public void affect(Property p, Entity e) {
		Kinetics d = (Kinetics) p;

		Vector3 a = d.accel; // FIXME
		Vector3 v = d.velocity; 
		double t = e.getCycleTime();

		// s = s + ( v*t + 0.5*a*t^2 )
		d.location = d.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  

		// v = v + at
		d.velocity = v.add( a.mult(t) );
	}

}
