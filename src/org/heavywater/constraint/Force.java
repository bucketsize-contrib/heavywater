package org.heavywater.constraint;

import org.heavywater.core.Constraint;
import org.heavywater.core.IConstraintResolver;
import org.heavywater.core.IResolver;
import org.heavywater.primitives.Vector3;

public class Force extends Constraint{
	
	private Vector3 origin;
	private Vector3 vector;
	
	public Force(Vector3 o, Vector3 v){
		origin = o;
		vector = v;
	}

	
	@Override
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("Force o=");
		sb.append(origin.inspect());
		sb.append(" v=");
		sb.append(vector.inspect());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IConstraintResolver) r).resolve(this);
	}
}