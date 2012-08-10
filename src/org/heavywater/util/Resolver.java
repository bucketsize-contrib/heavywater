package org.heavywater.util;

import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;

public interface Resolver {
	Object resolve(Dynamics dynamics);
	Object resolve(Kinetics kinetics);
	Object resolve(Base base);
}
