package org.heavywater.driver;

import org.heavywater.affector.Affector;
import org.heavywater.affector.EntityAffectorFactory;
import org.heavywater.affector.ParticleAffectorFactory;
import org.heavywater.entity.Entity;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{
	EntityAffectorFactory paff;
	
	public ParticleDriver(){
		super();
		paff = (EntityAffectorFactory)ParticleAffectorFactory.instance();
	}
	
	@Override
	public void drive(Entity e) {
		// update property changes - each individual property
		for(Property p: e.getProperties()){
			Affector a = paff.entityAffector(p);
			a.affect(p, e);
		}
	}
}