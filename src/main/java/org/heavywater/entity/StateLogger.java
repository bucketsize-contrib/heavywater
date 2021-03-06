package org.heavywater.entity;

import static org.heavywater.util.LogUtil.logInfo;

import org.heavywater.core.Entity;
import org.heavywater.core.EntityDriver;
import org.heavywater.core.Property;
import org.heavywater.core.IEntityResolver;
import org.heavywater.core.IResolver;

public class StateLogger extends Entity {

	public StateLogger(){
		this(null);
	}
	
	public StateLogger(EntityDriver ed) {
		super(ed);
	}
	
	public void step(){
		for(Entity e: ensemble ){
			logInfo(e.toString());
			for(Property p: e.getProperties()){
				logInfo("\t" + p.toString());
			}
		}
	}
	
	public Object dispatch(IEntityResolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect() {
		return "(StateLogger)";
	}
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IEntityResolver) r).resolve(this);
	}

}
