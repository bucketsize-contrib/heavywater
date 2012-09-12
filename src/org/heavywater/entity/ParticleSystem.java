package org.heavywater.entity;

import org.heavywater.driver.EntityDriver;
import org.heavywater.util.Resolver;
import org.heavywater.util.EntityStrDump;

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
		return EntityStrDump.generate(this);
	}

}
