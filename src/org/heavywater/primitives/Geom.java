package org.heavywater.primitives;

import org.heavywater.util.StrDump;

public abstract class Geom {
	
	StrDump fNot;
	
	public Geom(){
		fNot = new StrDump();
	}
	
	public String notation() {
		return fNot.generate(this);
	}

}
