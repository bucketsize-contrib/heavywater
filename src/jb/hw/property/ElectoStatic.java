package jb.hw.property;

import jb.hw.core.IPropertyResolver;
import jb.hw.core.IResolver;
import jb.hw.core.Property;

public class ElectoStatic extends Property {
	public double charge;	
	
	public String inspect() {
		return "ElectoStatic#inspect";
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}
}
