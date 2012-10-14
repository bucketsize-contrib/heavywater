package jb.hw.util;

import java.util.HashMap;
import java.util.Map;

public class InstanceFactory {
	private static Map<String, Class<?>> classPool = new HashMap<String, Class<?>>();
	private static Map<String, Object> instancePool = new HashMap<String, Object>();
	
	public static Object getInstance(String klass){
		Class<?> k = classPool.get(klass);
		if (k==null){
			try {
				k = Class.forName(klass);
				classPool.put(klass, k);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			return k.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static Object getCachedInstance(String klass){
		Object i = instancePool.get(klass);
		if (i==null){
			i = getInstance(klass);
			instancePool.put(klass, i);
		}
		return i;
	}
}
