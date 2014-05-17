package org.heavywater.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.heavywater.core.HException;

import static org.heavywater.util.LogUtil.*;

public class InstanceFactory {
	private Map<String, Class<?>> classPool = new HashMap<String, Class<?>>();
	private Map<String, Object> instancePool = new HashMap<String, Object>();
	
	private Properties classNames;
	
	private InstanceFactory() {
		classNames = new Properties();
		 
	    try {
	    	InputStream pfile = new FileInputStream("res/classcache.properties");
	    	classNames.load(pfile);
		} catch (IOException e) {
			throw new HException(e);
		}
	}

	public Object getInstance(String klass){
		//System.out.println("KLASS="+klass);
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
		}
		return i;
	}
	
	public String getClassName(String type){
		return classNames.getProperty(type);
	}

	private static InstanceFactory instance;
	public static InstanceFactory instance() {
		if (instance==null){
			instance = new InstanceFactory();
		}
		return instance;
	}

}
