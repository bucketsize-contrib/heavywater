package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IConfinement;
import org.heavywater.core.IResolver;
import org.heavywater.core.IShape;
import org.heavywater.core.Property;

public class Geometry extends Property {

	private IShape shape;
	private IConfinement confinement;
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public void copy(Property p) {
		// TODO Auto-generated method stub
		
	}

}
