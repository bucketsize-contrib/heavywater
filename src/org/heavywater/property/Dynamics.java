package org.heavywater.property;

import org.heavywater.affector.AffectorResolver;
import org.heavywater.primitives.Vector3;
import org.heavywater.util.prNotation;

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
	}
	
	@Override
	public Object dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}

	@Override
	public String inspect(prNotation n) {
		// TODO Auto-generated method stub
		return null;
	}

}
