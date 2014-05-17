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
	
	private Vector3 lAccel; // accel producted by thrust at CoM		

	private Vector3 wAccel; // angular accel produced by thrust about CoM
	
	private Vector3 fAccel; // cons produced by g/f/c/others
	
	public Vector3 getlAccel() {
		return lAccel;
	}

	public void setlAccel(Vector3 lAccel) {
		this.lAccel = lAccel;
	}

	public Vector3 getwAccel() {
		return wAccel;
	}

	public void setwAccel(Vector3 wAccel) {
		this.wAccel = wAccel;
	}

	public Vector3 getfAccel() {
		return fAccel;
	}

	public void setfAccel(Vector3 fAccel) {
		this.fAccel = fAccel;
	}
	
	public Dynamics(){
		lAccel = new Vector3();
		wAccel = new Vector3();
		fAccel = new Vector3();
		type = "Dynamics";
	}
		
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics ");
		sb.append(" a=");
		sb.append(lAccel.toString());
		sb.append(" w=");
		sb.append(wAccel.toString());
		sb.append(" f=");
		sb.append(fAccel.toString());
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
		lAccel.copy(d.lAccel);
		
	}
	
	
}
