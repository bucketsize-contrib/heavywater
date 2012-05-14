package org.heavywater.util;

public class Notation {
	protected static String nullNotation(){
		return "object is null";
	}
	protected static boolean sanitize(Object obj){
		if (obj == null){
			return false;
		}
		return true;
	}

}
