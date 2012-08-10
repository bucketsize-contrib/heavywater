package org.heavywater.affector;

import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;
import org.heavywater.util.Resolver;
import org.heavywater.util.Singleton;

public abstract class AffectorResolver implements Singleton, Resolver {
	public abstract Affector resolve(Kinetics kinetics);
	public abstract Affector resolve(Dynamics dynamics);
}

