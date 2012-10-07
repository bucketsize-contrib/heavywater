package org.heavywater.core;

import org.heavywater.constraint.Force;
import org.heavywater.constraint.Joint;

public interface IConstraintResolver extends IResolver{
	Object resolve(Force f);
	Object resolve(Joint j);
}
