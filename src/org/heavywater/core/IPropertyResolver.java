package org.heavywater.core;

import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Geometry;
import org.heavywater.property.Inertial;
import org.heavywater.property.Kinetics;

public interface IPropertyResolver extends IResolver{
	Object resolve(Dynamics d);
	Object resolve(Kinetics k);
	Object resolve(ElectoStatic e);
	Object resolve(Geometry g);
	Object resolve(Inertial i);
}
