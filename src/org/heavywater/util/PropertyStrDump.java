package org.heavywater.util;

import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Kinetics;

public class PropertyStrDump {
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
	
	public static String generate(ElectoStatic electoStaticProperty) {
		// TODO Auto-generated method stub
		return null;
	}

}
