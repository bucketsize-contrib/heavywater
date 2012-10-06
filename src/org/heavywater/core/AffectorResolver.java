package org.heavywater.core;

import org.heavywater.constraint.Force;
import org.heavywater.constraint.Joint;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Kinetics;

/**
 * @author jb
 *
 */
public abstract class AffectorResolver {
	public abstract Affector resolve(Dynamics ds);
	public abstract Affector resolve(Kinetics ks);
	public abstract Affector resolve(ElectoStatic es);
	public abstract Affector resolve(Force f);
	public abstract Affector resolve(Joint j);
}

