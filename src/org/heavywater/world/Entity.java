package org.heavywater.world;

import java.util.List;

/*
 * Entity is the primary object in the simulation world. It can have many parts
 * also entities.
 * It has properties, that define how it behaves - flow in viscous channel, or
 * drift in a magnetic field.
 * Simulation is based around entity type and its properties [AMBI].
 * EntityDriver visits all properties. 
 */
public class Entity {
	protected List<Entity> ensemble;
	protected List<Property> properties;	
	
	public void tick(EntityDriver driver){
		driver.drive(this);
	}
}
