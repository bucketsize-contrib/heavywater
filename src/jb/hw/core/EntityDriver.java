package jb.hw.core;

import java.util.HashMap;
import java.util.Map;

import jb.hw.affector.ConstraintAffectorResolver;
import jb.hw.affector.PropertyAffectorResolver;




/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public class EntityDriver implements IDriver {
	private IPropertyResolver pafr = null;
	private IConstraintResolver cafr = null;
	
	private Map<String, IAffector> paftrs;
	private Map<String, IAffector> caftrs;
	
	public EntityDriver(){
		paftrs = new HashMap<String, IAffector>();
		caftrs = new HashMap<String, IAffector>();
	}
	
	private void reloadAfftrs(Entity e) {
		pafr = new PropertyAffectorResolver(e);
		cafr = new ConstraintAffectorResolver(e);
		
		System.out.println("[1]:"+e);
		for(Property a: e.getProperties()){
			IAffector aff = (IAffector) a.dispatch(pafr);
			paftrs.put(a.getType(), aff);
		}
		
		
		System.out.println("[2]:"+e);
		for(Constraint a: e.getConstraints()){
			IAffector aff = (IAffector) a.dispatch(cafr);
			caftrs.put(a.getType(), aff);
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
		IAffector aff = null;
		for(Property a: e.getProperties()){
			aff = paftrs.get(a.getType());
			if (aff!=null) {
				// System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
				aff.affect((IAffectable) a, e);
			}
		}
		
		// update Constraint changes - each individual property
		for(Constraint a: e.getConstraints()){
			aff = paftrs.get(a.getType());
			if (aff!=null) {
				// System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
				aff.affect((IAffectable) a, e);
			}
		}
		
		// update ensemble
		for(Entity en: e.getEnsemble()){
			en.step();
		}
	}
	
}