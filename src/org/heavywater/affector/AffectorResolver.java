package org.heavywater.affector;

import org.heavywater.property.Dynamics;

public abstract class AffectorResolver {
	// any property should have minimally atleast a dynamics affector
	public abstract Affector resolve(Dynamics p);
}

