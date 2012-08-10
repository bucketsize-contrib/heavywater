package org.heavywater.entity;

import org.heavywater.driver.EntityDriver;
import org.heavywater.util.Resolver;
import org.heavywater.util.prNotation;

public class Sphere extends Shape {

	public float radius;
	
	public Sphere(EntityDriver ed) {
		super(ed);
		// TODO Auto-generated constructor stub
	}
	
	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect(prNotation n) {
		return n.generate(this);
	}

}
