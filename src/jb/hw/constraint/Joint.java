package jb.hw.constraint;

import jb.hw.core.Constraint;
import jb.hw.core.Entity;
import jb.hw.core.IConstraintResolver;
import jb.hw.core.IResolver;

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