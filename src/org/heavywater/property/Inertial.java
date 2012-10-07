package org.heavywater.property;

import org.heavywater.core.Property;
import org.heavywater.core.IPropertyResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.IVisitable;

public class Inertial  extends Property implements IVisitable{
	public double mass;
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}
}
