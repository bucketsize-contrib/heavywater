package org.heavywater.driver;

import org.heavywater.affector.AffectorResolver;
import org.heavywater.affector.ParticleAffectorResolver;

public class ParticleDriver extends EntityDriver{
	public ParticleDriver(){
		setAffectorResolver((AffectorResolver)ParticleAffectorResolver.instance());
	}	
	
}