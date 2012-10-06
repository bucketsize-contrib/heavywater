package org.heavywater.core;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Kinetics;

public interface Resolver {
	// entity
	Object resolve(Engine engine);
	Object resolve(Particle particle);
	Object resolve(ParticleSystem particleSystem);
	Object resolve(StateLogger stateLogger);
	Object resolve(Entity entity);
	
	//property
	Object resolve(Dynamics dynamics);
	Object resolve(Kinetics kinetics);
	Object resolve(ElectoStatic electo);
}
