package org.heavywater.constraint;

import org.heavywater.core.Constraint;
import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.Property;
import org.heavywater.primitives.Vector3;

public class Thrust extends Constraint {

	public static Thrust initial = new Thrust();
	public Vector3 force;
	
	public Thrust(){
		force = new Vector3();
	}
	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}

	public void copy(Constraint p) {
		Thrust t = (Thrust) p;
		force.copy(t.force);
	}
	
}
