package org.heavywater.util;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Entity;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

public class TypeResolver implements Resolver {

	public Object resolve(Engine b) {
		return "Engine";
	}

	public Object resolve(Particle b) {
		return "Particle";
	}

	public Object resolve(ParticleSystem b) {
		return "ParticleSystem";
	}

	public Object resolve(Kinetics b) {
		return "Kinetics";
	}

	public Object resolve(Dynamics b) {
		return "Dynamics";
	}

	@Override
	public Object resolve(ElectoStaticProperty b) {
		return "ElectoStaticProperty";
	}

	@Override
	public Object resolve(StateLogger stateLogger) {
		// TODO Auto-generated method stub
		return "StateLogger";
	}

	@Override
	public Object resolve(Entity entity) {
		throw new RuntimeException("shouldnt be here!");
	}

}
