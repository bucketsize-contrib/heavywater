package org.heavywater.property;

import org.heavywater.primitives.Vector3;

public class Dynamics extends Property {
	protected float mass;
	
	protected Vector3 accel;		
	protected Vector3 a_accel;

	protected Vector3 momentum;
	protected Vector3 a_momentum;
	
	protected Vector3 g_accel;
}
