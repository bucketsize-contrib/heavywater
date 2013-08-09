package org.heavywater.core;


public interface IConstraintResolver extends IResolver{
	Object resolve(Constraint f);
	void setEntity(Entity e);
}
