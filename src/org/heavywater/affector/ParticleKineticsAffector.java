package org.heavywater.affector;

import org.heavywater.core.Entity;
import org.heavywater.core.IAffectable;
import org.heavywater.core.IAffector;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.DynamicsAggregator;
import org.heavywater.property.Kinetics;
import org.heavywater.util.InstanceFactory;


public class ParticleKineticsAffector implements IAffector{
	
	// compute kinematics from other affectables
	// there can be one or more secondary, depends on the affector scheme
	// single: when all tertiaries coalesce to one one secondary
	// multiple: when there can be a secondary per tertiary
	public void affect(IAffectable p, Entity e) {
		Kinetics k = (Kinetics) p;

		DynamicsAggregator ag = (DynamicsAggregator) InstanceFactory
				.getInstance("org.heavywater.property.DynamicsAggregator");
		
		Dynamics d = (Dynamics) ag.aggregate( e.getProperties("Dynamics") ); 
		
		Vector3 a = d.l_accel.add(d.f_accel);
		Vector3 v = k.velocity; 
		double t = e.getCycleTime();

		// s = s + ( v*t + 0.5*a*t^2 )
		k.location = k.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  

		// v = v + at
		k.velocity = v.add( a.mult(t) );
	}
			
}
