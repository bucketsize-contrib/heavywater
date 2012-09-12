package org.heavywater.ptypes;

import org.heavywater.util.PtypesStrDump;

public abstract class Geom {
	
	PtypesStrDump fNot;
	
	public Geom(){
		fNot = new PtypesStrDump();
	}
	
	public String notation() {
		return fNot.generate(this);
	}

}
