package org.heavywater.affector.resolver;

import org.heavywater.constraint.Force;
import org.heavywater.constraint.Joint;
import org.heavywater.core.Affector;
import org.heavywater.core.AffectorResolver;
import org.heavywater.core.Singleton;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Kinetics;

public class ParticleSystemAffectorResolver extends AffectorResolver implements Singleton {
		// singleton
		private static Object ins;
		public static Object instance() {
			return ins != null ? ins : (ins = new ParticleSystemAffectorResolver());
		}
		// !singleton
		@Override
		public Affector resolve(Dynamics dynamics) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Affector resolve(Kinetics kinetics) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public Affector resolve(ElectoStatic electoStaticProperty) {
			// TODO Auto-generated method stub
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
