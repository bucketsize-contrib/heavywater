package org.heavywater.affector;

import org.heavywater.entity.Entity;
import org.heavywater.property.Property;

public abstract class Affector {
	public abstract void affect(Property p, Entity e);
}
