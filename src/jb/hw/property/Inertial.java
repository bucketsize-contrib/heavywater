package jb.hw.property;

import jb.hw.core.IPropertyResolver;
import jb.hw.core.IResolver;
import jb.hw.core.IVisitable;
import jb.hw.core.Property;

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
