package jb.hw.property;

import jb.hw.core.IPropertyResolver;
import jb.hw.core.IResolver;
import jb.hw.core.Property;

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
