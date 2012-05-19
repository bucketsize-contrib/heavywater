package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorFactory;

/**
 * Property as of now only signifies physical properties an Entity can have.
 * Behaviour is tied to entity based on properties it holds, not on type.
 * This kind of makes for duck typing in a strongly typed language. 
 */
public abstract class Property {
	public abstract Affector entityAffector(AffectorFactory aff);
}
