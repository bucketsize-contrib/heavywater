package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorResolver;
import org.heavywater.primitives.Vector3;
import org.heavywater.util.prNotation;

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

	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}

	@Override
	public String inspect(prNotation n) {
		return n.generate(this);
	}
	
	
}
