package org.heavywater.affector;

import org.heavywater.property.Dynamics;

public class ParticleAffectorResolver extends AffectorResolver {
	// singleton
	private static Object ins;

	public static Object instance() {
		return ins != null ? ins : (ins = create());
	}

	private static Object create() {
		return new ParticleAffectorResolver();
	}
	// !singleton
	
	public Affector resolve(Dynamics p) {
		return (Affector) ParticleDynamicsAffector.instance();
	}

}
