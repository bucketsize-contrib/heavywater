package jb.hw.core;

import jb.hw.engine.Engine;
import jb.hw.entity.Particle;
import jb.hw.entity.ParticleSystem;
import jb.hw.entity.StateLogger;
import jb.hw.property.Dynamics;
import jb.hw.property.ElectoStatic;
import jb.hw.property.Kinetics;


public interface IEntityResolver extends IResolver{
	Object resolve(Engine engine);
	Object resolve(Particle particle);
	Object resolve(ParticleSystem particleSystem);
	Object resolve(StateLogger stateLogger);
}
