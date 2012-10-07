package org.heavywater.entity;

import org.heavywater.core.Entity;
import org.heavywater.core.EntityDriver;
import org.heavywater.core.IEntityResolver;
import org.heavywater.core.IResolver;

public class Particle extends Entity {
	
	public Particle(EntityDriver ed) {
		super(ed);
	}

	public Particle() {
		super();
	}

	public Object dispatch(IEntityResolver resolver) {
		return resolver.resolve(this);
	}
	
	public String inspect() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Particle ");
		sb.append(getID());
		sb.append(" ");
		sb.append(getCycleTime());
		sb.append(" ");
		sb.append(getAliveTime());
		sb.append(")");
		
		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IEntityResolver) r).resolve(this);
	}
}
