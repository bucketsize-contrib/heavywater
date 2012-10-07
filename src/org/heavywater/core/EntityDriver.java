package org.heavywater.core;

import java.util.ArrayList;
import java.util.List;



/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public class EntityDriver {
	private IPropertyResolver pafr = null;
	private IConstraintResolver cafr = null;
	
	private List<Affector> paftrs;
	private List<Affector> caftrs;
	
	public EntityDriver(){
		paftrs = new ArrayList<Affector>();
		caftrs = new ArrayList<Affector>();
	}
	
	private void reloadAfftrs(Entity e) {
		pafr = new PropertyAffectorResolver(e);
		cafr = new ConstraintAffectorResolver(e);
		
		System.out.println("[1]:"+e);
		for(Property p: e.getProperties()){
			Affector aff = (Affector) p.dispatch(pafr);
			paftrs.add(aff);
		}
		
		
		System.out.println("[2]:"+e);
		for(Constraint p: e.getConstraints()){
			Affector aff = (Affector) p.dispatch(pafr);
			caftrs.add(aff);
		}
	}
	
	/**
	 *  Called by Entity#step, this causes evaluation of Affector on Entity 
	 *  Property.
	 *  	 
	 *  @param e
	 */
	public void drive(Entity e) {
		if (pafr == null || cafr == null){
			reloadAfftrs(e);
		}
		
		// update Property changes - each individual property
		for(Property p: e.getProperties()){
			Affector aff = (Affector) p.dispatch(pafr);
			if (aff!=null) {
				// System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
				aff.affect((IAffectable) p, e);
			}
		}
		
		// update Constraint changes - each individual property
		for(Constraint c: e.getConstraints()){
			Affector aff = (Affector) c.dispatch(cafr);
			if (aff!=null) {
				// System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
				aff.affect((IAffectable) c, e);
			}
		}
		
		// update ensemble
		for(Entity en: e.getEnsemble()){
			en.step();
		}
	}
	
}
