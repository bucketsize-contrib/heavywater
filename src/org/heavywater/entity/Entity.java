package org.heavywater.entity;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.ArrayList;
import java.util.List;

import org.heavywater.constraint.Constraint;
import org.heavywater.driver.EntityDriver;
import org.heavywater.property.Property;
import org.heavywater.util.Base;
import org.heavywater.util.TypeResolver;
import org.heavywater.util.Visitable;
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

public abstract class Entity extends Base implements Visitable {	
	protected List<Property> properties;
	protected List<Constraint> constraints;	

	protected List<Entity> ensemble;
	protected Entity parent;
	
	protected double cycleTime;
	protected double aliveTime;

	protected EntityDriver driver;
	
	public Entity(){
		this(new EntityDriver());
	}
	public Entity(EntityDriver ed) {
		driver = ed;
		parent = null;
		cycleTime = 0.0;
		aliveTime = 0.0;
		properties = new ArrayList<Property>();
		ensemble = new ArrayList<Entity>();
		type = (String) dispatch(new TypeResolver());
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
	
	public List<Property> getProperties(String t) {
		List<Property> tlist = new ArrayList<Property>();
		for(Property e: properties){
			if (e.getType().equals(t)){
				tlist.add(e);
			}
		}
		return tlist;
	}
	
	public List<Constraint> getConstraints(String t) {
		List<Constraint> tlist = new ArrayList<Constraint>();
		for(Constraint e: constraints){
			if (e.getType().equals(t)){
				tlist.add(e);
			}
		}
		return tlist;
	}


}
