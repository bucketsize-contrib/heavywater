package org.heavywater.driver;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorResolver;
import org.heavywater.entity.Entity;
import org.heavywater.property.Property;

/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public abstract class EntityDriver {
	private AffectorResolver afr = null;
	public void setAffectorResolver(AffectorResolver _afr){
		afr=_afr;
	}
	public void drive(Entity e) {
		// update property changes - each individual property
		for(Property p: e.getProperties()){
			Affector a = (Affector) p.dispatch(afr);
			a.affect(p, e);
		}
	}
}
