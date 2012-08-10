package org.heavywater.affector;

import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

public abstract class AffectorResolver {
	public abstract Affector resolve(Dynamics dynamics);
	public abstract Affector resolve(Kinetics kinetics);
	public abstract Affector resolve(ElectoStaticProperty electoStaticProperty);
}

