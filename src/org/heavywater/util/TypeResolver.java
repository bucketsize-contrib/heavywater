package org.heavywater.util;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

public class TypeResolver implements Resolver {

	public Object resolve(Engine b) {
		b.type = "Engine";
		return null;
	}

	public Object resolve(Particle b) {
		b.type = "Particle";
		return null;
	}

	public Object resolve(ParticleSystem b) {
		b.type = "ParticleSystem";
		return null;
	}

	public Object resolve(Kinetics b) {
		b.type = "Kinetics";
		return null;
	}

	public Object resolve(Dynamics b) {
		b.type = "Dynamics";
		return null;
	}

	@Override
	public Object resolve(ElectoStaticProperty b) {
		b.type = "ElectoStaticProperty";
		return null;
	}

	@Override
	public Object resolve(StateLogger stateLogger) {
		// TODO Auto-generated method stub
		return null;
	}

}
