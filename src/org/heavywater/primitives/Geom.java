package org.heavywater.primitives;

import org.heavywater.util.FNotation;

public abstract class Geom {
	
	FNotation fNot;
	
	public Geom(){
		fNot = new FNotation();
	}
	
	public String notation() {
		return fNot.generate(this);
	}

}
