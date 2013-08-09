package org.heavywater.core;


public interface IPropertyResolver extends IResolver{
	Object resolve(Property p);
	void setEntity(Entity e);
}
