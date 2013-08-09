package org.heavywater.core;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.ArrayList;
import java.util.List;

import org.heavywater.util.InstanceFactory;


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

public abstract class Entity extends Base implements IVisitable {	
	protected List<Property> properties;
	protected List<Constraint> constraints;	

	protected List<Entity> ensemble;
	protected Entity parent;
	
	protected double cycleTime; // seconds
	protected double aliveTime; // seconds

	protected EntityDriver driver;
	
	public Entity(){
		this((EntityDriver) InstanceFactory.getInstance("org.heavywater.core.EntityDriver"));
	}
	
	public Entity(EntityDriver ed) {
		driver = ed;
		parent = null;
		cycleTime = 0.0;
		aliveTime = 0.0;
		properties = new ArrayList<Property>();
		constraints = new ArrayList<Constraint>();
		ensemble = new ArrayList<Entity>();
		logInfo("new "+ type +", id= " + id);
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
	
	// -- ACCESSORS --
	public void add(Entity e) {
		e.parent = this;
		e.cycleTime = e.cycleTime!=0.0?e.cycleTime:cycleTime;		
		ensemble.add(e);
	}

	public void add(Property p) {
		properties.add(p);
	}
	
	public void add(Constraint c) {
		constraints.add(c);
	}
	
	public List<Entity> getEnsemble() {
		return ensemble;
	}
	
	public List<Property> getProperties() {
		return properties;
	}
	
	public List<Constraint> getConstraints() {
		return constraints;
	}
	
	public List<Entity> getEnsemble(String t) {
		List<Entity> tlist = new ArrayList<Entity>();
		for(Entity e: ensemble){
			if (e.type == t){
				tlist.add(e);
			}
		}
		return tlist;
	}	
	
	public List<IAffectable> getProperties(String t) {
		List<IAffectable> tlist = new ArrayList<IAffectable>();
		for(Property e: properties){
			if (e.getType().equals(t)){
				tlist.add((IAffectable) e);
			}
		}
		return tlist;
	}
	
	public List<IAffectable> getConstraints(String t) {
		List<IAffectable> tlist = new ArrayList<IAffectable>();
		for(Constraint e: constraints){
			if (e.getType().equals(t)){
				tlist.add((IAffectable) e);
			}
		}
		return tlist;
	}

}
