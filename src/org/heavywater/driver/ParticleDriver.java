package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.entity.Particle;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{

	@Override
	public void drive(Entity e) {
		for(Property p: e.getProperties()){
			p.transform((Particle)e);
		}
	}
	
}
