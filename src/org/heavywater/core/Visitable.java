package org.heavywater.core;


public interface Visitable{
	public Object dispatch(Resolver r);
}