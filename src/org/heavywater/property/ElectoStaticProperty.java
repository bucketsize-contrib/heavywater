package org.heavywater.property;

import org.heavywater.util.Resolver;
import org.heavywater.util.prNotation;

public class ElectoStaticProperty extends Property {
	public double charge;
	
	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect(prNotation n) {
		return n.generate(this);
	}
}
