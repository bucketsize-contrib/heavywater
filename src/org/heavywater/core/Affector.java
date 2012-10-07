package org.heavywater.core;

import java.util.List;

public abstract class Affector {
	public abstract void affect(IAffectable p, Entity e);
	public abstract IAffectable aggregate(List<IAffectable> lp);
}
