package org.heavywater.util;

import org.heavywater.primitives.Axis3;
import org.heavywater.primitives.Geom;
import org.heavywater.primitives.Line3;
import org.heavywater.primitives.Matrix4;
import org.heavywater.primitives.Quaternion;
import org.heavywater.primitives.Vector3;

public class StrDump{	
	protected static String nullNotation(){
		return "object is null";
	}
	protected static boolean sanitize(Object obj){
		if (obj == null){
			return false;
		}
		return true;
	}
	public static String generate(Vector3 geometry) {
		if (!sanitize(geometry)) return nullNotation();
		return "(Vector3 " + geometry.X() + " " + geometry.Y() + " "
				+ geometry.Z()+")";

	}

	public static String generate(Quaternion geometry) {
		if (!sanitize(geometry)) return nullNotation();
		return "(Quaternion " + geometry.W() + " " +geometry.X() + " " + geometry.Y() + " "
		+ geometry.Z()+")";

	}

	public static String generate(Line3 geometry) {
		if (!sanitize(geometry)) return nullNotation();
		return "(Line3 " + geometry.vertices()[0].notation() + " "
				+ geometry.vertices()[1].notation() + ")";

	}

	public static String generate(Axis3 geometry) {
		if (!sanitize(geometry)) return nullNotation();
		return "A geometric Axis3d";

	}

	public static String generate(Matrix4 geometry) {
		if (!sanitize(geometry)) return nullNotation();
		String s = "(Matrix4 ";
		double [][] a = geometry.array();
		for (int i = 0; i < 4; ++i){
			s+="\n(";
			for (int j = 0; j < 4; ++j){
				s+=a[i][j]+" ";				
			}
			s+=")";
		}
		return s+")";
	}

	public String generate(Geom geometry) {
		if (!sanitize(geometry)) return nullNotation();
		return "Geom";
	}
}
