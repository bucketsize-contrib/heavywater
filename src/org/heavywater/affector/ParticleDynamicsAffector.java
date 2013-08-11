package org.heavywater.affector;

import java.util.List;

import org.heavywater.constraint.Thrust;
import org.heavywater.core.Entity;
import org.heavywater.core.IAffectable;
import org.heavywater.core.IAffector;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Inertial;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector implements IAffector{

	public void affect(IAffectable p, Entity e) {
		Dynamics d = (Dynamics) p;

		List<IAffectable> thrusts = e.getConstraints("Thrust");
		List<IAffectable> inertials = e.getConstraints("Inertial");

		if (inertials.size() > 0){
			Inertial inertial = (Inertial) e.getConstraints("Inertial").get(0);

			Vector3 sforce = new Vector3();
			for(IAffectable thrust: thrusts){
				Vector3 force = ((Thrust)thrust).force;
				sforce.add(force);
			}

			d.l_accel = sforce.mult(1/inertial.mass);
		}
	}
}
