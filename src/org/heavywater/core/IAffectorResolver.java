package org.heavywater.core;


public interface IAffectorResolver extends IResolver{

	void setEntity(Entity e);

	Object resolve(Property p);

	Object resolve(Constraint c);
	
}
