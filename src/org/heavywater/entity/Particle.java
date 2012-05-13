package org.heavywater.entity;

import org.heavywater.driver.ParticleDriver;
import org.heavywater.property.Dynamics;


public class Particle extends Entity {

	public Particle(){
		this(new ParticleDriver());
	}
	public Particle(ParticleDriver ed) {
		super(ed);
	}	
}
