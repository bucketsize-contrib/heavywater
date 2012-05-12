package org.heavywater.entity;

import java.util.List;

import org.heavywater.driver.EntityDriver;
import org.heavywater.property.Property;

/**
 * Entity is the primary object in the simulation world. It can have many parts
 * also entities.
 * 
 * It has properties, that define how it behaves - flow in viscous channel, or
 * drift in a magnetic field.
 * 
 * Simulation is based around entity type and its properties [AMBI].
 * EntityDriver visits all properties. 
 */
public class Entity {
	protected List<Property> properties;
	protected EntityDriver driver;
	
	protected Entity parent;	
	protected List<Entity> ensemble;
	
	public Entity(EntityDriver ed){
		driver = ed;
	}
	public List<Entity> getEnsemble() {
		return ensemble;
	}

	public void add(Entity entity){
		ensemble.add(entity);
	}
	
	public void driver(EntityDriver _driver){
		driver = _driver;
	}
	public void tick(){
		driver.drive(this);
	}
}
