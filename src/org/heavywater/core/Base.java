package org.heavywater.core;


public abstract class Base {
	protected static int pIndex=0;
	
	protected int id=-1;
	protected String type;
	
	public Base(){
		id = pIndex++;
		String i = this.getClass().toString();
		String[] s = i.split("\\."); 
		type = s[s.length - 1];
	}
	
	public long getID() {
		return id;
	}
	
	public String getType(){
		return type;
	}

	public abstract String inspect();
	
}
