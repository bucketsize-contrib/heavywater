package org.heavywater.affector;

import static org.heavywater.util.LogUtil.logInfo;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Kinetics;
import org.heavywater.property.Property;
import org.heavywater.util.Singleton;
import org.heavywater.util.prNotation;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector extends Affector{
	// singleton
	private static Object ins;	
	public static Object instance(){
		return ins!=null?ins:(ins=new ParticleDynamicsAffector());
	}
	// !singleton

	@Override
	public void affect(Property p, Entity e) {
		
	}

}
