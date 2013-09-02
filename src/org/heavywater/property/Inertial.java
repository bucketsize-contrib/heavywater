package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.IVisitable;
import org.heavywater.core.Property;

public class Inertial  extends Property implements IVisitable{
	private double mass;
	
	public double getMass() {
		return mass;
	}

	public void setMass(double mass) {
		this.mass = mass;
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Inertial");
		sb.append(" m=");
		sb.append(mass);
		sb.append(")");

		return sb.toString();
	}

	@Override
	public void copy(Property p) {
		// TODO Auto-generated method stub
		
	}
}
