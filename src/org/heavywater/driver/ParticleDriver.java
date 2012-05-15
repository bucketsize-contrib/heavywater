package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.entity.Particle;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{
	@Override
	public void drive(Entity e) {
		// update property changes - each induvidual property
		for(Property p: e.getProperties()){
			Affector a = p.affector();
			a.affect(p, e);
		}
	}
}
