package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.Property;
import org.heavywater.primitives.Vector3;

// primary; this will yield due to changes in secondarie(s)
// ie - dynamics
// NOTE: when the context changes to chemical reactions / biochemical inteactions
// primary and secondary will change to more apt parameters
// like reaction energies, geospatial scores
// how ever former primaries can figure as tertiary properties, depending on the
// affector scheme
public class Kinetics extends Property {
	// primary properties; not modifiable by external
	public Vector3 location;	
	public Vector3 velocity;
	public Vector3 a_velocity;
	public Vector3 s_accel; // constant acceleration due to gravity / electro-magnetism

	public Kinetics(){
		location = new Vector3();

		velocity = new Vector3();
		a_velocity = new Vector3();
		type = "Kinetics";
	}

	
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Kinetics");
		sb.append(" p=");
		sb.append(location.inspect());
		sb.append(" v=");
		sb.append(velocity.inspect());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}


	@Override
	public void copy(Property p) {
		Kinetics k = (Kinetics) p;
		
		velocity.setX(k.velocity.X());
		velocity.setY(k.velocity.Y());
		velocity.setZ(k.velocity.Z());
		
		a_velocity.setX(k.a_velocity.X());
		a_velocity.setY(k.a_velocity.Y());
		a_velocity.setZ(k.a_velocity.Z());
		
	}
	
}
