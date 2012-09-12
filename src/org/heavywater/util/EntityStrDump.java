package org.heavywater.util;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Entity;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;

public class EntityStrDump {
	protected static String nullNotation(){
		return "object is null";
	}
	protected static boolean sanitize(Object obj){
		if (obj == null){
			return false;
		}
		return true;
	}
	public static String generate(Kinetics d) {
		if (!sanitize(d)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Kinetics");
		sb.append(" ");
		sb.append(PtypesStrDump.generate(d.location));
		sb.append(" ");
		sb.append(PtypesStrDump.generate(d.velocity));
		sb.append(")");

		return sb.toString();
	}
	
	public static String generate(Dynamics d) {
		if (!sanitize(d)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics ");
		sb.append(PtypesStrDump.generate(d.accel));
		sb.append(" ");
		sb.append(PtypesStrDump.generate(d.a_accel));
		sb.append(")");

		return sb.toString();
	}

	public static String generate(Engine engine) {
		if (!sanitize(engine)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Engine ");
		sb.append(engine.getID());
		sb.append(" ");
		sb.append(engine.getCycleTime());
		sb.append(" ");
		sb.append(engine.getAliveTime());
		sb.append(" ");
		sb.append(engine.getListeners().size());
		sb.append(")");
		
		return sb.toString();
	}

	public static String generate(Particle particle) {
		if (!sanitize(particle)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Particle ");
		sb.append(particle.getID());
		sb.append(" ");
		sb.append(particle.getCycleTime());
		sb.append(" ");
		sb.append(particle.getAliveTime());
		sb.append(")");
		
		return sb.toString();
		}

	public static String generate(ParticleSystem particleSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String generate(StateLogger stateLogger) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static String generate(Entity entity) {
		throw new RuntimeException("shouldnt be here!");
	}

}
