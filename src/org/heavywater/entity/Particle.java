package org.heavywater.entity;

import org.heavywater.driver.ParticleDriver;
import org.heavywater.util.Resolver;
import org.heavywater.util.hStrDump;

public class Particle extends Entity {
	public Particle(ParticleDriver ed) {
		super(ed);
	}	
	
	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect() {
		return hStrDump.generate(this);
	}

}
