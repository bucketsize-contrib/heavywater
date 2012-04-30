package org.heavywater.world.entity;

import org.heavywater.world.Entity;
import org.heavywater.world.Property;

public class Particle extends Entity {
	public Particle(Property p){
		ensemble = null;
		properties.add(p);
	}	
}
