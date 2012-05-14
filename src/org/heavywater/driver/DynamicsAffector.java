package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;
import org.heavywater.util.pNotation;
import org.heavywater.util.prNotation;

public class DynamicsAffector extends Affector{
	public void affect(Property p, Entity e) {
		Dynamics d = (Dynamics) p;
		System.out.println("[II] Particle before ="+prNotation.generate(d));
		Vector3 a = d.accel.add(d.g_accel);
		Vector3 v = d.velocity; 
		double t = e.getCycleTime();
		
		// s = s + ( v*t + 0.5*a*t^2 )
		d.location = d.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  
		
		// v = v + at
		d.velocity = v.add( a.mult(t) );

		System.out.println("[II] Particle after ="+prNotation.generate(d));
		System.out.println("[II] aliveTime = " + e.getAliveTime());
	}
		
}
