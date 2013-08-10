package org.heavywater.util;

public class HeavyUtil {
	public static String getReducedType(Object object){
		String i = object.getClass().toString();
		String[] s = i.split("\\."); 
		return s[s.length - 1];
	}
}
