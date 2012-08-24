package org.heavywater.entity;

import org.heavywater.driver.ParticleSystemDriver;
import org.heavywater.util.Resolver;
import org.heavywater.util.hStrDump;

public class ParticleSystem extends Entity {
	public ParticleSystem(ParticleSystemDriver ed) {
		super(ed);
	}
	
	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}
	
	public String inspect(){
		return hStrDump.generate(this);
	}

}
