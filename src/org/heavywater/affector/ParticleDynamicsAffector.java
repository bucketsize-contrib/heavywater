package org.heavywater.affector;

import java.util.List;

import org.heavywater.constraint.Thrust;
import org.heavywater.constraint.ThrustAggregator;
import org.heavywater.core.Entity;
import org.heavywater.core.IAffectable;
import org.heavywater.core.IAffector;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Inertial;
import org.heavywater.util.InstanceFactory;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector implements IAffector{
	
	public void affect(IAffectable p, Entity e) {
		Dynamics d = (Dynamics) p;

		List<IAffectable> thrusts = e.getConstraints("Thrust");
		List<IAffectable> inertials = e.getProperties("Inertial");

		if (inertials.size() > 0){
			Inertial inertial = (Inertial) inertials.get(0);

			InstanceFactory ifac = InstanceFactory.instance();
			ThrustAggregator ag = (ThrustAggregator) ifac.
					getInstance(ifac.getClassName("ThrustAggregator"));
			
			Thrust t = (Thrust) ag.aggregate(thrusts);

			d.setlAccel(t.getForce().mult(1.0/inertial.getMass()));
		}
	}
}
