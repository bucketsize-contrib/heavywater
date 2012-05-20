package org.heavywater.entity;

import java.util.ArrayList;
import java.util.List;

import org.heavywater.driver.EntityDriver;
import org.heavywater.property.Property;
import static org.heavywater.util.LogUtil.*
;/**
 * Entity is the primary object in the simulation world. It can have many parts
 * also entities.
 * 
 * It has properties, that define how it behaves - flow in viscous channel, or
 * drift in a magnetic field.
 * 
 * Simulation is based around entity type and its properties [AMBI].
 * EntityDriver visits all properties.
 */
public abstract class Entity {
	protected long id=-1;
	private static long pIndex=0; 
	
	protected double cycleTime;
	protected double aliveTime;
	
	protected List<Property> properties;
	protected List<Entity> ensemble;

	protected Entity parent;

	protected EntityDriver driver;

	public Entity(EntityDriver ed) {
		id = pIndex++;
		driver = ed;
		parent = null;
		cycleTime = 0.0;
		aliveTime = 0.0;
		properties = new ArrayList<Property>();
		ensemble = new ArrayList<Entity>();
		logInfo("new Entity "+"type="+this.getClass()+" id= "+pIndex);
	}

	
	public List<Entity> getEnsemble() {
		return ensemble;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void add(Entity entity) {
		entity.parent = this;
		entity.cycleTime = entity.cycleTime!=0.0?entity.cycleTime:cycleTime;		
		ensemble.add(entity);
	}

	public void add(Property p) {
		properties.add(p);
	}
	
	public void driver(EntityDriver d) {
		driver = d;
	}

	public void step() {
		driver.drive(this);
		aliveTime += cycleTime;
	}

	public void cycleTime(double t){
		cycleTime = t;
	}
	
	public double getCycleTime() {
		return cycleTime;
	}


	public double getAliveTime() {
		return aliveTime;
	}


	public long getID() {
		return id;
	}
}
