package org.heavywater.entity;

import java.util.ArrayList;
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
	protected Entity parent;
	protected List<Entity> ensemble;

	protected List<Property> properties;

	protected EntityDriver driver;

	protected double cycleTime;

	public Entity(EntityDriver ed) {
		driver = ed;
		parent = null;
		cycleTime = 1.0;
		properties = new ArrayList<Property>();
		ensemble = new ArrayList<Entity>();
	}

	public List<Entity> getEnsemble() {
		return ensemble;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void add(Entity entity) {
		entity.cycleTime = cycleTime;
		entity.parent = this;
		ensemble.add(entity);
	}

	public void driver(EntityDriver d) {
		driver = d;
	}

	public void tick() {
		driver.drive(this);
	}

	public double getCycleTime() {
		return cycleTime;
	}
}
