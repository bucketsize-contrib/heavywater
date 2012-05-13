package org.heavywater.property;

import org.heavywater.driver.Affector;
import org.heavywater.entity.Entity;

/**
 * Property as of now only signifies physical properties an Entity can have.
 * Behaviour is tied to entity based on properties it holds, not on type.
 * This kind of makes for duck typing in a strongly typed language. 
 */
public class Property {
	/**
	 * transforms an Entity based on this property
	 * @param e
	 */
	public void transform(Entity e){		
		Affector a = affector();
		a.affect(this, e);
	}

	/**
	 * gets the Affector implementation for this property
	 * @return
	 */
	public Affector affector() {
		// TODO Auto-generated method stub
		return new Affector();
	}
}
