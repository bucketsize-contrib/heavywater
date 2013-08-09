package org.heavywater.affector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.heavywater.core.Entity;
import org.heavywater.core.HException;
import org.heavywater.core.IPropertyResolver;
import org.heavywater.core.Property;
import org.heavywater.util.InstanceFactory;

public class PropertyAffectorResolver implements IPropertyResolver {
	Entity entity;
	Properties prop;
	
	public PropertyAffectorResolver() {
		prop = new Properties();
		 
	    try {
	    	InputStream pfile = new FileInputStream("res/affectors.properties");
			prop.load(pfile);
		} catch (IOException e) {
			throw new HException(e);
		}
	}
	
	@Override
	public Object resolve(Property p) {
		return InstanceFactory.getInstance(prop.getProperty(entity.getType()+p.getType()));
	}

	@Override
	public void setEntity(Entity e) {
		entity = e;
	}
}
