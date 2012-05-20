package org.heavywater.entity;

import static org.heavywater.util.LogUtil.logInfo;

import org.heavywater.driver.EntityDriver;
import org.heavywater.property.Property;
import org.heavywater.util.prNotation;

public class StateLogger extends Entity {

	public StateLogger(){
		this(null);
	}
	
	public StateLogger(EntityDriver ed) {
		super(ed);
	}
	
	public void step(){
		for(Entity e: ensemble ){
			logInfo("Entity: "+e.getID()+" - "+e.getAliveTime());
			for(Property p: e.getProperties()){
				logInfo(p.inspect((prNotation)prNotation.instance()));
			}
		}
	}
	

}
