package jb.hw.entity;

import static jb.hw.util.LogUtil.logInfo;
import jb.hw.core.Entity;
import jb.hw.core.EntityDriver;
import jb.hw.core.IEntityResolver;
import jb.hw.core.IResolver;
import jb.hw.core.Property;


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
	
	public Object dispatch(IEntityResolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect() {
		return "StateLogger#inspect";
	}
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IEntityResolver) r).resolve(this);
	}

}
