package org.heavywater.affector;

import org.heavywater.property.Dynamics;

public abstract class AffectorFactory {
	public abstract Affector resolve(Dynamics p);
}

