package org.heavywater.util;

public abstract class Base {
	protected static long pIndex=0;
	
	protected long id=-1;
	protected String type; 
	
	public Base(){
		id = pIndex++;
	}
	public long getID() {
		return id;
	}
	
	public String getType(){
		return type;
	}
	
	
	public Object dispatch(Resolver afr) {
		return afr.resolve(this);
	}

	
	public String inspect(prNotation n) {
		return n.generate(this);
	}

}
