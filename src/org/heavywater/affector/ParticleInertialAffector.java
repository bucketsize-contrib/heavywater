package org.heavywater.affector;

import org.heavywater.core.Entity;
import org.heavywater.core.IAffectable;
import org.heavywater.core.IAffector;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleInertialAffector  implements IAffector{

	public void affect(IAffectable p, Entity e) {
		// nothing happens to inertial mass unless relativistic effects are considered
	}

}

