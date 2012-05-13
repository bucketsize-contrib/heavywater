package org.heavywater.driver;

import org.heavywater.entity.Entity;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;
import org.heavywater.util.pNotation;

public class ParticleDriver extends EntityDriver{

	@Override
	public void drive(Entity e) {
		ParticleAffector paff = new ParticleAffector();
		for(Property p: e.getProperties()){
			paff.affect(p, e);
		}
	}
	
}
