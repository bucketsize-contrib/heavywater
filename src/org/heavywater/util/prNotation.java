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

public class prNotation extends Notation implements Singleton{
	// singleton
	private static prNotation ins;
	public static prNotation instance() {
		return ins != null ? ins : (ins = new prNotation());
	}
	// !singleton

	public String generate(Kinetics d) {
		if (!sanitize(d)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Kinetics");
		sb.append(" loc ");
		sb.append(pNotation.generate(d.location));
		sb.append(" vel ");
		sb.append(pNotation.generate(d.velocity));
		sb.append(")");

		return sb.toString();
	}
	
	public String generate(Dynamics d) {
		if (!sanitize(d)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics");
		sb.append(" acc ");
		sb.append(pNotation.generate(d.accel));
		sb.append(" wacc ");
		sb.append(pNotation.generate(d.a_accel));
		sb.append(")");

		return sb.toString();
	}

	public String generate(Engine engine) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(Mesh mesh) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(Particle particle) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(ParticleSystem particleSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(PotentialMesh potentialMesh) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(Shape shape) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(StateLogger stateLogger) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(ElectoStaticProperty electoStaticProperty) {
		// TODO Auto-generated method stub
		return null;
	}

}
