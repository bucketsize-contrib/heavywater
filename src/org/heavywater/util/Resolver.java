package org.heavywater.util;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Mesh;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.PotentialMesh;
import org.heavywater.entity.Shape;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

public interface Resolver {
	Object resolve(Dynamics dynamics);
	Object resolve(Kinetics kinetics);
	Object resolve(ElectoStaticProperty electoStaticProperty);
	Object resolve(Engine engine);
	Object resolve(Mesh mesh);
	Object resolve(Particle particle);
	Object resolve(ParticleSystem particleSystem);
	Object resolve(PotentialMesh potentialMesh);
	Object resolve(Shape shape);
	Object resolve(StateLogger stateLogger);
}
