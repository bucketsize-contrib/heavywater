package org.heavywater.entity;

import org.heavywater.driver.ParticleSystemDriver;

public class ParticleSystem extends Entity {
	
	public ParticleSystem(){
		this(new ParticleSystemDriver());
	}
	public ParticleSystem(ParticleSystemDriver ed) {
		super(ed);
	}
	
}
