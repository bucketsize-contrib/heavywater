package org.heavywater.core;

import org.heavywater.affector.ConstraintAffectorResolver;
import org.heavywater.affector.PropertyAffectorResolver;

/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public class EntityDriver implements IDriver {
	private IPropertyResolver pafr = null;
	private IConstraintResolver cafr = null;
	
	public EntityDriver(){
		pafr = new PropertyAffectorResolver();
		cafr = new ConstraintAffectorResolver();
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
			IAffector aff = (IAffector) property.dispatch(pafr);
			aff.affect((IAffectable) property, e);
		}
		
		// update Constraint changes - each individual property
		for(Constraint constrain: e.getConstraints()){
			IAffector aff = (IAffector) constrain.dispatch(cafr);
			aff.affect((IAffectable) constrain, e);
		}
		
		// update ensemble
		for(Entity en: e.getEnsemble()){
			en.step();
		}
	}

	private void setContext(Entity e) {
		pafr.setEntity(e);
		cafr.setEntity(e);		
	}
}
