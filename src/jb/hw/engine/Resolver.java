package jb.hw.engine;

import java.util.List;

import jb.hw.core.Entity;


/**
 * Resolver acts on an a set of entities for a given event. 
 * This is called  either by the engine or by the entity / entityDriver.
 */
public abstract class Resolver {
	public abstract void resolve(List<Entity> entities);
}
