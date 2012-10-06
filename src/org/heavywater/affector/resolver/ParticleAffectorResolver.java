package org.heavywater.affector.resolver;

import org.heavywater.affector.ParticleDynamicsAffector;
import org.heavywater.affector.ParticleKineticsAffector;
import org.heavywater.constraint.Force;
import org.heavywater.constraint.Joint;
import org.heavywater.core.Affector;
import org.heavywater.core.AffectorResolver;
import org.heavywater.core.Singleton;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Kinetics;

public class ParticleAffectorResolver extends AffectorResolver implements Singleton {
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

	public Affector resolve(ElectoStatic electoStatics) {
		return null;
	}

	@Override
	public Affector resolve(Force f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Affector resolve(Joint j) {
		// TODO Auto-generated method stub
		return null;
	}
}
