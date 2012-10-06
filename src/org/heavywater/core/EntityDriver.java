package org.heavywater.core;

import static org.heavywater.util.LogUtil.logInfo;


/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public class EntityDriver {
	private AffectorResolver afr = null;
	
	/**
	 * Needs to be called to set the correct AffectorResolver after driver 
	 * instanciation.
	 * 
	 * @param _afr
	 */
	public void setAffectorResolver(AffectorResolver _afr){
		afr=_afr;
	}
	
	public void setAffectorResolver(Entity en){
		// doing this i dont have to set, resolvers in driver
		// hence can use a unified driver
		logInfo("loading class [jb]: "+"org.heavywater.affector.resolver." +en.getType() + "AffectorResolver");
		try {
			afr = (AffectorResolver) Class.forName("org.heavywater.affector.resolver." +en.getType().toString() + "AffectorResolver").newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 *  Called by Entity#step, this causes evaluation of Affector on Entity 
	 *  Property.
	 *  	 
	 *  @param e
	 */
	public void drive(Entity e) {
		// an afr should be attached beyond this
		if (afr == null){
			setAffectorResolver(e);
		}
		
		// update Property changes - each individual property
		for(Property p: e.getProperties()){
			Affector aff = (Affector) p.dispatch(afr);
			if (aff!=null) {
				//System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
				aff.affect(p, e);
			}
		}
		
		// update Constraint changes - each individual property
		for(Constraint c: e.getConstraints()){
			Affector aff = (Affector) c.dispatch(afr);
			if (aff!=null) {
				//System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
				aff.affect(c, e);
			}
		}
		
		
		// update ensemble
		for(Entity en: e.getEnsemble()){
			en.step();
		}
	}
}
