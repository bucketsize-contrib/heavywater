package org.heavywater.driver;

import org.heavywater.entity.Entity;

/**
 * EntityDriver know how each Property affect this particular Entity.
 * 
 * EntityDriver is also to delegate away some of the dynamic behaviour away
 * from the Entity object.
 */
public abstract class EntityDriver {
	public abstract void drive(Entity e);
}
