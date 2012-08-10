package org.heavywater.util;

import org.heavywater.property.Kinetics;

public class prNotation extends Notation{
	// singleton
	private static Object ins;
	public static Object instance() {
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

	public String generate(Base base) {
		// TODO Auto-generated method stub
		return null;
	}
}
