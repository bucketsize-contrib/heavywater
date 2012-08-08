package org.heavywater.driver;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorFactory;
import org.heavywater.affector.ParticleAffectorFactory;
import org.heavywater.entity.Entity;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{
	AffectorFactory aff;
	
	public ParticleDriver(){
		super();
		aff = (AffectorFactory)ParticleAffectorFactory.instance();
	}
	
	@Override
	public void drive(Entity e) {
		// update property changes - each individual property
		for(Property p: e.getProperties()){
			Affector a = (Affector) p.dispatch(aff);
			a.affect(p, e);
		}
	}
}