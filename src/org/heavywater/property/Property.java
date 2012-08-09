package org.heavywater.property;

import org.heavywater.affector.Affector;
import org.heavywater.affector.AffectorResolver;
import org.heavywater.util.prNotation;

/**
 * Property as of now only signifies physical properties an Entity can have.
 * Behaviour is tied to entity based on properties it holds, not on type.
 * This kind of makes for duck typing in a strongly typed language. 
 */
public abstract class Property {
	public abstract Object dispatch(AffectorResolver afr);
	public abstract String inspect(prNotation n);
}
