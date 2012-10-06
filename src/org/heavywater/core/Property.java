package org.heavywater.core;


/**
 * Property as of now only signifies physical properties an Entity can have.
 * Behaviour is tied to entity based on properties it holds, not on type.
 */
 public abstract class Property extends Base implements Affectable{
	public abstract Affector dispatch(AffectorResolver afr);
}
