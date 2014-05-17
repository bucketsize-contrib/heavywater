package org.heavywater.core;

public interface IConfinement {
	boolean collidesWith(IConfinement c);
	boolean contains(IConfinement c);
	void create(IShape s);
}
