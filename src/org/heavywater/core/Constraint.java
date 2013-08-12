package org.heavywater.core;


// Constrains are
// - Force
// - Reactive Force
// - Torque
// - Reactive Torque
// - Field
// - PlayBack
// - AI
// directly effects Dynamics
// is affected by other Property(s)
public abstract class Constraint 
extends Base 
implements IVisitable, IAffectable{
	
	public abstract void copy(Constraint p);
	
}