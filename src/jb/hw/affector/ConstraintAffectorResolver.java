package jb.hw.affector;

import jb.hw.constraint.Force;
import jb.hw.constraint.Joint;
import jb.hw.core.Entity;
import jb.hw.core.IConstraintResolver;
import jb.hw.util.InstanceFactory;


public class ConstraintAffectorResolver implements IConstraintResolver {
	final String PREFIX = "jb.hw.affector.";
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
