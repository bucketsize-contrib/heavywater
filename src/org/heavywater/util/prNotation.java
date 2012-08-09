package org.heavywater.util;

import org.heavywater.affector.ParticleAffectorResolver;
import org.heavywater.property.Kinetics;

public class prNotation extends Notation{
	// singleton
	private static Object ins;

	public static Object instance() {
		return ins != null ? ins : (ins = create());
	}

	private static Object create() {
		return new prNotation();
	}
	// !singleton

	public String generate(Kinetics d) {
		if (!sanitize(d)) return nullNotation();
		StringBuffer sb = new StringBuffer();
		sb.append("(Dynamics");
		sb.append(" loc ");
		sb.append(pNotation.generate(d.location));
		sb.append(" vel ");
		sb.append(pNotation.generate(d.velocity));
		sb.append(")");

		return sb.toString();
	}
}
