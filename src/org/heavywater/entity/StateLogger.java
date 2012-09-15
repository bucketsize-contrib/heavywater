package org.heavywater.entity;

import static org.heavywater.util.LogUtil.logInfo;

import org.heavywater.driver.EntityDriver;
import org.heavywater.property.Property;
import org.heavywater.util.Resolver;

public class StateLogger extends Entity {

	public StateLogger(){
		this(null);
	}
	
	public StateLogger(EntityDriver ed) {
		super(ed);
	}
	
	public void step(){
		for(Entity e: ensemble ){
			logInfo(e.inspect());
			for(Property p: e.getProperties()){
				logInfo("\t" + p.inspect());
			}
		}
	}
	
	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect() {
		return "StateLogger#inspect";
	}

}
