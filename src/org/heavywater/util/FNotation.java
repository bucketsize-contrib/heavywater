package org.heavywater.util;

import org.heavywater.geom.Vector3;
import org.heavywater.geom.Line3;
import org.heavywater.geom.Matrix4;
import org.heavywater.geom.Quaternion;
import org.heavywater.geom.Axis3;

public class FNotation {

	public static String generate(Vector3 geometry) {
		return "(Vector3 " + geometry.getX() + " " + geometry.getY() + " "
				+ geometry.getZ()+")";

	}

	public static String generate(Quaternion geometry) {
		return "(Quaternion " + geometry.getW() + " " +geometry.getX() + " " + geometry.getY() + " "
		+ geometry.getZ()+")";

	}

	public static String generate(Line3 geometry) {
		return "(Line3 " + geometry.getVertices()[0].notation() + " "
				+ geometry.getVertices()[1].notation() + ")";

	}

	public static String generate(Axis3 geometry) {
		return "A geometric Axis3d";

	}

	public static String generate(Matrix4 geometry) {
		String s = "(Matrix4 ";
		double [][] a = geometry.getAsArray();
		for (int i = 0; i < 4; ++i){
			s+="\n(";
			for (int j = 0; j < 4; ++j){
				s+=a[i][j]+" ";				
			}
			s+=")";
		}
		return s+")";
	}
}
