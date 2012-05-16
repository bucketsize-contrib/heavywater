package org.heavywater.affector;

import org.heavywater.property.Property;

public class ParticleAffectorFactory extends EntityAffectorFactory {

	@Override
	public Affector entityAffector(Property p) {
		return new ParticleDynamicsAffector();
	}

}	
