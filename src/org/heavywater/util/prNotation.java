package org.heavywater.util;

import org.heavywater.property.Dynamics;

public class prNotation extends Notation{
	public static String generate(Dynamics d) {
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
