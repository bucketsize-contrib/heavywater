package org.heavywater.property;

import org.heavywater.core.Property;
import org.heavywater.core.IPropertyResolver;
import org.heavywater.core.IResolver;

public class ElectoStatic extends Property {
	public double charge;	
	
	public String inspect() {
		return "ElectoStatic#inspect";
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}

	@Override
	public void copy(Property p) {
		// TODO Auto-generated method stub
		
	}
}
