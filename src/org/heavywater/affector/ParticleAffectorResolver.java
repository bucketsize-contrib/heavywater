package org.heavywater.affector;

import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;
import org.heavywater.util.Base;

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

	public Affector resolve(Dynamics d) {
		return (Affector) ParticleDynamicsAffector.instance();
	}

	@Override
	public Object resolve(Base base) {
		return null;
	}

}
