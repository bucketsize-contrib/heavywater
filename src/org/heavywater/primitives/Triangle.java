package org.heavywater.primitives;

import org.heavywater.core.IPrimitive;

public class Triangle implements IPrimitive{
	private Vector3 [] verts;
	
	public Triangle(){
		verts = new Vector3[3];
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return "(Triangle "+verts+")" ;
	}
}
