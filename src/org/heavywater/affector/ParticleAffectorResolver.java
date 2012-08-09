package org.heavywater.affector;

import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;

public class ParticleAffectorResolver extends AffectorResolver {
	// singleton
	private static Object ins;
	public static Object instance() {
		return ins != null ? ins : (ins = new ParticleAffectorResolver());
	}
	// !singleton
	
	public Affector resolve(Kinetics p) {
		return (Affector) ParticleKineticsAffector.instance();
	}

	@Override
	public Affector resolve(Dynamics dynamics) {
		return (Affector) ParticleDynamicsAffector.instance();
	}

}
