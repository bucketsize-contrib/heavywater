package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.Property;

public class ElectoStatic extends Property {
	private double charge;	
	
	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public String inspect() {
		return "ElectoStatic#inspect";
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public void copy(Property p) {
		// TODO Auto-generated method stub
		
	}
}
