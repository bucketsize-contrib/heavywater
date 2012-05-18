package org.heavywater.affector;

import org.heavywater.property.Property;
import org.heavywater.util.InstanceCache;

public class ParticleAffectorFactory extends EntityAffectorFactory {
	private static Object ins;
	
	public static Object instance(){
		return ins!=null?ins:(ins=create());
	}
	
	private static Object create(){
		return new ParticleAffectorFactory();
	}
	
	@Override
	public Affector entityAffector(Property p) {
		return (Affector) ParticleDynamicsAffector.instance();
	}

}	
