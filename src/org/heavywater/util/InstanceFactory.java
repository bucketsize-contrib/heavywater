package org.heavywater.util;

import java.util.HashMap;
import java.util.Map;

import org.heavywater.core.HException;
import static org.heavywater.util.LogUtil.*;

public class InstanceFactory {
	private static Map<String, Class<?>> classPool = new HashMap<String, Class<?>>();
	private static Map<String, Object> instancePool = new HashMap<String, Object>();

	public static Object getInstance(String klass){
		Class<?> k = classPool.get(klass);
		if (k==null){
			try {
				k = Class.forName(klass);
				classPool.put(klass, k);
				logInfo("cached class: "+klass);
			} catch (ClassNotFoundException e) {
				throw new HException(e);
			}
		}

		Object i = instancePool.get(klass);
		if (i == null){
			try {
				i = k.newInstance();
				instancePool.put(klass, i);
				logInfo("cached instance: "+klass);
			} catch (InstantiationException e) {
				throw new HException(e);
			} catch (IllegalAccessException e) {
				throw new HException(e);
			}
		}else{
		}
		return i;
	}

}
