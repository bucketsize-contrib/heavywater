package jb.hw.property;

import jb.hw.core.IPropertyResolver;
import jb.hw.core.IResolver;
import jb.hw.core.Property;
import jb.hw.primitives.Vector3;


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
		
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics ");
		sb.append(accel.notation());
		sb.append(" ");
		sb.append(a_accel.notation());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}
}