package org.heavywater.entity;

import org.heavywater.driver.EntityDriver;
import org.heavywater.util.EntityResolver;
import org.heavywater.util.EntityStrDump;

public class Particle extends Entity {
	
	public Particle(EntityDriver ed) {
		super(ed);
	}

	public Particle() {
		super();
	}

	public Object dispatch(EntityResolver resolver) {
		return resolver.resolve(this);
	}
	
	public String inspect() {
		return EntityStrDump.generate(this);
	}
}
