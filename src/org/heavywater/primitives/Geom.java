package org.heavywater.primitives;

import org.heavywater.util.pNotation;

public abstract class Geom {
	
	pNotation fNot;
	
	public Geom(){
		fNot = new pNotation();
	}
	
	public String notation() {
		return fNot.generate(this);
	}

}
