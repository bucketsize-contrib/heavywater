package jb.hw.core;

import jb.hw.constraint.Force;
import jb.hw.constraint.Joint;

public interface IConstraintResolver extends IResolver{
	Object resolve(Force f);
	Object resolve(Joint j);
}
