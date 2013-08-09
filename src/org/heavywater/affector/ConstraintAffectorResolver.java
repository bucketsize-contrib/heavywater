package org.heavywater.affector;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.IConstraintResolver;
import org.heavywater.util.InstanceFactory;

public class ConstraintAffectorResolver implements IConstraintResolver {
	Entity entity;
	Properties prop;
	
	public ConstraintAffectorResolver() {
		prop = new Properties();
		 
	    try {
	    	InputStream pfile = new FileInputStream("res/affectors.properties");
			prop.load(pfile);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}
	
	@Override
	public Object resolve(Constraint p) {
		return InstanceFactory.getInstance(prop.getProperty(entity.getType()+p.getType()));
	}

	@Override
	public void setEntity(Entity e) {
		entity = e;
	}
}
