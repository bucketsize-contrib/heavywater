package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{

	@Override
	public void drive(Entity e) {
		for(Property p: e.getProperties()){
			affect(p, e);
		}
	}
	
	private void affect(Property p, Entity e) {
		System.out.println("[WW] unexpected property: " + p.getClass() );
	}
	
	private void affect(Dynamics d, Entity e) {
		Vector3 a = d.accel.add(d.g_accel);
		Vector3 v = d.velocity; 
		double t = e.getCycleTime();
		
		// s = s + ( v*t + 0.5*a*t^2 )
		d.location = d.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  
		
		// v = v + at
		d.velocity = v.add( a.mult(t) );
	}
}
