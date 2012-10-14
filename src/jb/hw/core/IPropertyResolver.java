package jb.hw.core;

import jb.hw.property.Dynamics;
import jb.hw.property.ElectoStatic;
import jb.hw.property.Geometry;
import jb.hw.property.Inertial;
import jb.hw.property.Kinetics;

public interface IPropertyResolver extends IResolver{
	Object resolve(Dynamics d);
	Object resolve(Kinetics k);
	Object resolve(ElectoStatic e);
	Object resolve(Geometry g);
	Object resolve(Inertial i);
}
