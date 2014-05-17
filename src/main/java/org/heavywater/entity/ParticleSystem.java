package org.heavywater.entity;

import org.heavywater.core.Entity;
import org.heavywater.core.EntityDriver;
import org.heavywater.core.IEntityResolver;
import org.heavywater.core.IResolver;

public class ParticleSystem extends Entity {
	
	public ParticleSystem(EntityDriver ed) {
		super(ed);
	}
	
	public ParticleSystem() {
		super();
	}

	public Object dispatch(IEntityResolver afr) {
		return afr.resolve(this);
	}
	
	public String inspect(){
		return "ParticleSystem#inspect";
	}
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IEntityResolver) r).resolve(this);
	}
}
