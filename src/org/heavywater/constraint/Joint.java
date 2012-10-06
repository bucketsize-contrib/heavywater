package org.heavywater.constraint;

import org.heavywater.core.Affector;
import org.heavywater.core.AffectorResolver;
import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.Resolver;

public class Joint extends Constraint{
	Entity[] entities = new Entity[2];

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