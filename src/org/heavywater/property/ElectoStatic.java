package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.resolver.AffectorResolver;
import org.heavywater.util.Resolver;
import org.heavywater.util.PropertyStrDump;

public class ElectoStatic extends Property {
	public double charge;	
	
	public String inspect() {
		return PropertyStrDump.generate(this);
	}

	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}

	public Object dispatch(Resolver afr) {
		// TODO Auto-generated method stub
		return null;
	}
}
