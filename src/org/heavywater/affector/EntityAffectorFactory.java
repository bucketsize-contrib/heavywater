package org.heavywater.affector;

import org.heavywater.property.Property;

public abstract class EntityAffectorFactory {
	public abstract Affector entityAffector(Property p);
}

