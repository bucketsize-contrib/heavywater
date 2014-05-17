package org.heavywater.core;

import org.heavywater.affector.AffectorResolver;

/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public class EntityDriver extends Base implements IDriver {
	private IAffectorResolver afr = null;
	
	public EntityDriver(){
		afr = (IAffectorResolver) new AffectorResolver();
	}
	
	/**
	 *  Called by Entity#step, this causes evaluation of Affector on Entity 
	 *  Property.
	 *  	 
	 *  @param e
	 */
	public void drive(Entity e) {
		
		setContext(e);
		
		// update Property changes - each individual property
		for(Property property: e.getProperties()){
			IAffector aff = (IAffector) property.dispatch((IResolver)afr);
			aff.affect((IAffectable) property, e);
		}
		
		// update Constraint changes - each individual property
		for(Constraint constrain: e.getConstraints()){
			IAffector aff = (IAffector) constrain.dispatch((IResolver)afr);
			aff.affect((IAffectable) constrain, e);
		}
		
		// update ensemble
		for(Entity en: e.getEnsemble()){
			en.step();
		}
	}

	private void setContext(Entity e) {
		afr.setEntity(e);
	}

}
