package org.heavywater.property;

import org.heavywater.primitives.Vector3;

public class Dynamics extends Property {
	public Vector3 location;
	public Vector3 velocity;
	public Vector3 angular_velocity;

	public double mass;

	public Vector3 accel;		
	public Vector3 a_accel;

	public Vector3 momentum;
	public Vector3 a_momentum;

	public Vector3 g_accel;

	public Dynamics(){
		location = new Vector3();
		velocity = new Vector3();
		angular_velocity = new Vector3();

		mass = 0.0;

		accel = new Vector3();
		a_accel = new Vector3();

		momentum = new Vector3();
		a_momentum = new Vector3();

		g_accel = new Vector3();
	}
}
