package org.heavywater.driver;

import org.heavywater.affector.Affector;
import org.heavywater.affector.ParticleAffectorFactory;
import org.heavywater.entity.Entity;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{
	@Override
	public void drive(Entity e) {
		// update property changes - each induvidual property
		ParticleAffectorFactory pf = new ParticleAffectorFactory();
		for(Property p: e.getProperties()){
			Affector a = pf.entityAffector(p);
			a.affect(p, e);
		}
	}
}
