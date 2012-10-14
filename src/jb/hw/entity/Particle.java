package jb.hw.entity;

import jb.hw.core.Entity;
import jb.hw.core.EntityDriver;
import jb.hw.core.IEntityResolver;
import jb.hw.core.IResolver;

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
