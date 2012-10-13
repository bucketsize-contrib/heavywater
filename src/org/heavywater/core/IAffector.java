package org.heavywater.core;

import java.util.List;

public interface IAffector {
	public void affect(IAffectable p, Entity e);
	public IAffectable aggregate(List<IAffectable> lp);
}
