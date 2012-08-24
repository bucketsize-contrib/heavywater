package org.heavywater.util;

import java.awt.Shape;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

public class hStrDump {
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
		sb.append(" loc ");
		sb.append(StrDump.generate(d.location));
		sb.append(" vel ");
		sb.append(StrDump.generate(d.velocity));
		sb.append(")");

		return sb.toString();
	}
	
	public static String generate(Dynamics d) {
		if (!sanitize(d)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics");
		sb.append(" acc ");
		sb.append(StrDump.generate(d.accel));
		sb.append(" wacc ");
		sb.append(StrDump.generate(d.a_accel));
		sb.append(")");

		return sb.toString();
	}

	public static String generate(Engine engine) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String generate(Particle particle) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String generate(ParticleSystem particleSystem) {
		// TODO Auto-generated method stub
		return null;
	}

	public String generate(Shape shape) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String generate(StateLogger stateLogger) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String generate(ElectoStaticProperty electoStaticProperty) {
		// TODO Auto-generated method stub
		return null;
	}

}
