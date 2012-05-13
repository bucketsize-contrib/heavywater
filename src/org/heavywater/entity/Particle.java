package org.heavywater.entity;

import org.heavywater.driver.ParticleDriver;


public class Particle extends Entity {

	public Particle(){
		this(new ParticleDriver());
	}
	public Particle(ParticleDriver ed) {
		super(ed);
	}	
}
