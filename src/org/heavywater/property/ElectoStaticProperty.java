package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorResolver;
import org.heavywater.util.Resolver;
import org.heavywater.util.prNotation;

public class ElectoStaticProperty extends Property {
	public double charge;
	
	
	
	public String inspect(prNotation n) {
		return n.generate(this);
	}



	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}



	public Object dispatch(Resolver afr) {
		// TODO Auto-generated method stub
		return null;
	}
}
