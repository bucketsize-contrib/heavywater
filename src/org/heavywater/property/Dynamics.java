package org.heavywater.property;

import org.heavywater.core.Property;
import org.heavywater.core.IPropertyResolver;
import org.heavywater.core.IResolver;
import org.heavywater.primitives.Vector3;

//defectors/secondary; modified by tertiary - affects primary
//there can be single or multiple
//there can be one or more secondary, depends on the affector implementation
//single: when all tertiaries coalesce to one one secondary
//multiple: when there can be a secondary per tertiary
//tertiaries are:
//ie electrostatic, magnetic, gravitational, contact, viscous, hydraulic fields
public class Dynamics extends Property{
	
	public static Dynamics initial = new Dynamics();
	
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
		sb.append(" a=");
		sb.append(accel.inspect());
		sb.append(" w=");
		sb.append(a_accel.inspect());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}

	@Override
	public void copy(Property p) {
		Dynamics d = (Dynamics) p;
		
		accel.setX(d.accel.X());
		accel.setY(d.accel.Y());
		accel.setZ(d.accel.Z());
		
		a_accel.setX(d.a_accel.X());
		a_accel.setY(d.a_accel.Y());
		a_accel.setZ(d.a_accel.Z());
		
	}
	
	
}
