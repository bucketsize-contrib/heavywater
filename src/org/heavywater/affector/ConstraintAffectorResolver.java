package org.heavywater.affector;

import org.heavywater.constraint.Force;
import org.heavywater.constraint.Joint;
import org.heavywater.core.Entity;
import org.heavywater.core.IConstraintResolver;
import org.heavywater.util.InstanceFactory;

public class ConstraintAffectorResolver implements IConstraintResolver {
	final String PREFIX = "org.heavywater.affector.";
	final String POSTFIX = "Affector";
	Entity e;

	public ConstraintAffectorResolver(Entity e) {
		this.e = e;
	}

	@Override
	public Object resolve(Force f) {
		// TODO Auto-generated method stub
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

	@Override
	public Object resolve(Joint f) {
		// TODO Auto-generated method stub
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

}
