package jb.hw.property;

import jb.hw.core.IPropertyResolver;
import jb.hw.core.IResolver;
import jb.hw.core.Property;
import jb.hw.primitives.Vector3;


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
	public Vector3 angular_velocity;

	public Kinetics(){
		location = new Vector3();

		velocity = new Vector3();
		angular_velocity = new Vector3();
		type = "Kinetics";
	}

	
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Kinetics");
		sb.append(" ");
		sb.append(location.notation());
		sb.append(" ");
		sb.append(velocity.notation());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}
	
}
