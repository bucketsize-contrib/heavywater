package org.heavywater.driver;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorResolver;
import org.heavywater.affector.ParticleAffectorResolver;
import org.heavywater.entity.Entity;
import org.heavywater.property.Property;

public class ParticleDriver extends EntityDriver{
	AffectorResolver aff;
	
	public ParticleDriver(){
		super();
		aff = (AffectorResolver) ParticleAffectorResolver.instance();
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