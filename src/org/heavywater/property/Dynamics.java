package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.resolver.AffectorResolver;
import org.heavywater.ptypes.Vector3;
import org.heavywater.util.EntityStrDump;
import org.heavywater.util.Resolver;

//defectors/secondary; modified by tertiary - affects primary
//there can be single or multiple
//there can be one or more secondary, depends on the affector implementation
//single: when all tertiaries coalesce to one one secondary
//multiple: when there can be a secondary per tertiary
//tertiaries are:
//ie electrostatic, magnetic, gravitational, contact, viscous, hydraulic fields
public class Dynamics extends Property{
	public Vector3 accel;		
	public Vector3 a_accel;

	public Dynamics(){
		accel = new Vector3();
		a_accel = new Vector3();
		type = "Dynamics";
	}
	
	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}
	
	public String inspect() {
		return EntityStrDump.generate(this);
	}

	public Object dispatch(Resolver afr) {
		// TODO Auto-generated method stub
		return null;
	}

}
