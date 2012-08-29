package org.heavywater.util;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Entity;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

public interface Resolver {
	Object resolve(Dynamics dynamics);
	Object resolve(Kinetics kinetics);
	Object resolve(ElectoStaticProperty electoStaticProperty);
	Object resolve(Engine engine);
	Object resolve(Particle particle);
	Object resolve(ParticleSystem particleSystem);
	Object resolve(StateLogger stateLogger);
	Object resolve(Entity entity);
}
