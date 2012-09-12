package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.resolver.AffectorResolver;
import org.heavywater.ptypes.Vector3;
import org.heavywater.util.EntityStrDump;
import org.heavywater.util.Resolver;

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
		return EntityStrDump.generate(this);
	}

	@Override
	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}


	@Override
	public Object dispatch(Resolver afr) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
