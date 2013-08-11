package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.Property;
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
	
	public Vector3 l_accel; // accel producted by thrust at CoM		
	public Vector3 w_accel; // angular accel produced by thrust about CoM
	
	public Vector3 f_accel; // cons produced by g/f/c/others
	
	public Dynamics(){
		l_accel = new Vector3();
		w_accel = new Vector3();
		f_accel = new Vector3();
		type = "Dynamics";
	}
		
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics ");
		sb.append(" a=");
		sb.append(l_accel.inspect());
		sb.append(" w=");
		sb.append(w_accel.inspect());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public void copy(Property p) {
		Dynamics d = (Dynamics) p;
		
		l_accel.setX(d.l_accel.X());
		l_accel.setY(d.l_accel.Y());
		l_accel.setZ(d.l_accel.Z());
		
		w_accel.setX(d.w_accel.X());
		w_accel.setY(d.w_accel.Y());
		w_accel.setZ(d.w_accel.Z());
		
	}
	
	
}
