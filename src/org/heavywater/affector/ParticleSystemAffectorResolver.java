package org.heavywater.affector;

import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;
import org.heavywater.util.Singleton;

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
		public Affector resolve(ElectoStaticProperty electoStaticProperty) {
			// TODO Auto-generated method stub
			return null;
		}
}
