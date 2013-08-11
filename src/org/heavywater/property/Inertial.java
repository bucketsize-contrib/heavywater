package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.IVisitable;
import org.heavywater.core.Property;

public class Inertial  extends Property implements IVisitable{
	public double mass;
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public String inspect() {
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
