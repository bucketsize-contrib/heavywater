package org.heavywater.core;


// visitor that visits entity and resolved an affector
// 0: a resolver for each entity type; resolve using double dispatch
// 1: reflect to select a resolver 
public interface IAffectorResolver extends IResolver{

	void setEntity(Entity e);

	Object resolve(Property p);

	Object resolve(Constraint c);
	
}
