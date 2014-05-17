package org.heavywater.affector;

import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.Property;
import org.heavywater.util.InstanceFactory;

public class AffectorResolver implements IAffectorResolver {
	Entity entity;
	static InstanceFactory ifac = InstanceFactory.instance();
	
	@Override
	public Object resolve(Property p) {
		return ifac.getInstance(ifac.getClassName((entity.getType()+p.getType())));
	}


	@Override
	public Object resolve(Constraint c) {
		return ifac.getInstance(ifac.getClassName((entity.getType()+c.getType())));
	}
	
	@Override
	public void setEntity(Entity e) {
		entity = e;
	}

}
