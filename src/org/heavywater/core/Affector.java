package org.heavywater.core;

import java.util.List;

public abstract class Affector {
	public abstract void affect(Affectable p, Entity e);
	public abstract Affectable aggregate(List<Affectable> lp);
}
