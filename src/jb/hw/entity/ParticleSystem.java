package jb.hw.entity;

import jb.hw.core.Entity;
import jb.hw.core.EntityDriver;
import jb.hw.core.IEntityResolver;
import jb.hw.core.IResolver;

public class ParticleSystem extends Entity {
	
	public ParticleSystem(EntityDriver ed) {
		super(ed);
	}
	
	public ParticleSystem() {
		super();
	}

	public Object dispatch(IEntityResolver afr) {
		return afr.resolve(this);
	}
	
	public String inspect(){
		return "ParticleSystem#inspect";
	}
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IEntityResolver) r).resolve(this);
	}
}
