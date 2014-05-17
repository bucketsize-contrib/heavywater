package org.heavywater.core;

import static org.heavywater.util.LogUtil.*;

import org.heavywater.util.HeavyUtil;

public abstract class Base {
	protected static int pIndex=0;
	
	protected int id=-1;
	protected String type;
	
	public Base(){
		id = pIndex++;
		type = HeavyUtil.getReducedType(this);

		logInfo("spawned "+type+" id="+id);
	}
	
	public long getID() {
		return id;
	}
	
	public String getType(){
		return type;
	}

}
