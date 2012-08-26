package org.heavywater.affector.resolver;

import org.heavywater.affector.Affector;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStaticProperty;
import org.heavywater.property.Kinetics;

/**
 * @author jb
 *
 */
public abstract class AffectorResolver {
	public abstract Affector resolve(Dynamics dynamics);
	public abstract Affector resolve(Kinetics kinetics);
	public abstract Affector resolve(ElectoStaticProperty electoStaticProperty);
}

