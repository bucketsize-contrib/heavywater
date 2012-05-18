package org.heavywater.util;

import java.util.HashMap;
import java.util.Map;

public class InstanceCache {
	private static Map<String, Object> pool = new HashMap<String, Object>();
	
	public static void put(String key, Object val){
		pool.put(key.toString(), val);
	}
	
	public static Object update(String key, Object val){
		pool.put(key.toString(), val);
		return val;
	}
	
	public static Object get(String key){
		System.out.println("[II] cacheFetch: "+key);
		return pool.get(key);
	}
	
	public static boolean has(String key){
		if (pool.get(key) != null){
			return true;
		}else{
			return false;
		}
	}
	
}
