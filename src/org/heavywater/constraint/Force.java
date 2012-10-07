package org.heavywater.constraint;

import org.heavywater.core.Constraint;
import org.heavywater.core.IConstraintResolver;
import org.heavywater.core.IResolver;
import org.heavywater.ptypes.Vector3;

public class Force extends Constraint{
	
	private Vector3 origin;
	private Vector3 vector;
	
	public Force(Vector3 o, Vector3 v){
		origin = o;
		vector = v;
	}

	
	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IConstraintResolver) r).resolve(this);
	}
}