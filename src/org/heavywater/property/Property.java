package org.heavywater.property;


/**
 * Property as of now only signifies physical properties an Entity can have.
 * Behaviour is tied to entity based on properties it holds, not on type.
 * This kind of makes for duck typing in a strongly typed language. 
 */
public abstract class Property {
	/**
	 * gets the Affector implementation for this property
	 * @return
	 */
	public abstract Affector affector();
}
