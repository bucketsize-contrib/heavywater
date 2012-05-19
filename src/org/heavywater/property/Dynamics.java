package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorFactory;
import org.heavywater.primitives.Vector3;

public class Dynamics extends Property {
	public Vector3 location;
	
	public Vector3 velocity;
	public Vector3 angular_velocity;

	public Vector3 accel;		
	public Vector3 a_accel;

	public Dynamics(){
		location = new Vector3();

		velocity = new Vector3();
		angular_velocity = new Vector3();

		accel = new Vector3();
		a_accel = new Vector3();
	}

	public Affector entityAffector(AffectorFactory aff) {
		return aff.affector(this);
	}
	
	
}
