package org.heavywater.core;


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
	public abstract Object dispatch(Resolver afr);
	public abstract String inspect();
	
}
