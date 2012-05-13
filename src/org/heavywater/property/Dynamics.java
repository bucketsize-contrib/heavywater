package org.heavywater.property;

import org.heavywater.primitives.Vector3;

public class Dynamics extends Property {

	public Vector3 location;
	public Vector3 velocity;
	public Vector3 angular_velocity;
	
	public float mass;
	
	public Vector3 accel;		
	public Vector3 a_accel;

	public Vector3 momentum;
	public Vector3 a_momentum;
	
	public Vector3 g_accel;
}
