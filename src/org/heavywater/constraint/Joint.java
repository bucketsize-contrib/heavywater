package org.heavywater.constraint;

import java.util.List;

import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;

public class Joint extends Constraint{
	List<Entity> entities;
	
	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}


	@Override
	public void copy(Constraint p) {
		// TODO Auto-generated method stub
		
	}
}