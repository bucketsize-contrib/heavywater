package org.heavywater.constraint;

import org.heavywater.core.Constraint;
import org.heavywater.core.IConstraintResolver;
import org.heavywater.core.Entity;
import org.heavywater.core.IResolver;

public class Joint extends Constraint{
	Entity[] entities = new Entity[2];

	
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