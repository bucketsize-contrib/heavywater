package org.heavywater.property;

import org.heavywater.core.IPropertyResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.Property;

public class Geometry extends Property {

	//Mesh mesh;
	
	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IPropertyResolver) r).resolve(this);
	}

}
