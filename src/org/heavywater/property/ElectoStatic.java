package org.heavywater.property;

import org.heavywater.core.Affector;
import org.heavywater.core.AffectorResolver;
import org.heavywater.core.Property;
import org.heavywater.core.Resolver;

public class ElectoStatic extends Property {
	public double charge;	
	
	public String inspect() {
		return "ElectoStatic#inspect";
	}

	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}

	public Object dispatch(Resolver afr) {
		// TODO Auto-generated method stub
		return null;
	}
}
