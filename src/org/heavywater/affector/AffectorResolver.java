package org.heavywater.affector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.HException;
import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.Property;
import org.heavywater.util.InstanceFactory;

public class AffectorResolver implements IAffectorResolver {
	Entity entity;
	Properties prop;
	
	public AffectorResolver() {
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
	public Object resolve(Constraint c) {
		return InstanceFactory.getInstance(prop.getProperty(entity.getType()+c.getType()));
	}
	
	@Override
	public void setEntity(Entity e) {
		entity = e;
	}

}
