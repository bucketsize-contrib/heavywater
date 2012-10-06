package org.heavywater.constraint;

import org.heavywater.core.Affector;
import org.heavywater.core.AffectorResolver;
import org.heavywater.core.Constraint;
import org.heavywater.core.Resolver;
import org.heavywater.ptypes.Vector3;

public class Force extends Constraint{
	
	private Vector3 origin;
	private Vector3 vector;
	
	public Force(Vector3 o, Vector3 v){
		origin = o;
		vector = v;
	}

	@Override
	public Object dispatch(Resolver afr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Affector dispatch(AffectorResolver afr) {
		return afr.resolve(this);
	}
}