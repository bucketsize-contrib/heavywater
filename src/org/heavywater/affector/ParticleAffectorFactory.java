package org.heavywater.affector;

import org.heavywater.property.Dynamics;

public class ParticleAffectorFactory extends AffectorFactory {
	// singleton
	private static Object ins;

	public static Object instance() {
		return ins != null ? ins : (ins = create());
	}

	private static Object create() {
		return new ParticleAffectorFactory();
	}
	// !singleton
	
	public Affector resolve(Dynamics p) {
		return (Affector) ParticleDynamicsAffector.instance();
	}

}
