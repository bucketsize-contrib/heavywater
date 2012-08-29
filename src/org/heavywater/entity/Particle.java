package org.heavywater.entity;

import org.heavywater.driver.EntityDriver;
import org.heavywater.util.Resolver;
import org.heavywater.util.hStrDump;

public class Particle extends Entity {
	
	public Particle(EntityDriver ed) {
		super(ed);
	}

	public Particle() {
		super();
	}

	public Object dispatch(Resolver resolver) {
		return resolver.resolve(this);
	}
	
	public String inspect() {
		return hStrDump.generate(this);
	}
}
