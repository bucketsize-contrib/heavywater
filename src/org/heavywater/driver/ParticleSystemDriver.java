package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.entity.ParticleSystem;

public class ParticleSystemDriver extends EntityDriver {

	@Override
	public void drive(Entity e) {
		ParticleSystem ps = (ParticleSystem) e;
		for(Entity pa: ps.getEnsemble()){
			pa.step();
		}
	}

}
