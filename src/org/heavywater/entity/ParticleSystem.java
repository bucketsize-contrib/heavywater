package org.heavywater.entity;

import org.heavywater.core.Entity;
import org.heavywater.core.EntityDriver;
import org.heavywater.core.Resolver;

public class ParticleSystem extends Entity {
	
	public ParticleSystem(EntityDriver ed) {
		super(ed);
	}
	
	public ParticleSystem() {
		super();
	}

	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}
	
	public String inspect(){
		return "ParticleSystem#inspect";
	}

}
