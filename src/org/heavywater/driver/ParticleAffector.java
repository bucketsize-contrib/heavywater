package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;
import org.heavywater.util.pNotation;

public class ParticleAffector {

//	public void affect(Property p, Entity e) {
//		System.out.println("[WW] unknown property detected");
//	}
	
	public void affect(Dynamics d, Entity e) {
		
		System.out.println("[II] Particle before = ( "+pNotation.generate(d.location)+" )");
		System.out.println("[II] ( "+pNotation.generate(d.velocity)+" )");
		
		Vector3 a = d.accel.add(d.g_accel);
		Vector3 v = d.velocity; 
		double t = e.getCycleTime();
		
		// s = s + ( v*t + 0.5*a*t^2 )
		d.location = d.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  
		
		// v = v + at
		d.velocity = v.add( a.mult(t) );

		System.out.println("[II] Particle after = ( "+pNotation.generate(d.location)+" )");
		System.out.println("[II] ( "+pNotation.generate(d.velocity)+" )");

	}


}
