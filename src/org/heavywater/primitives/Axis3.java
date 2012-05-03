package org.heavywater.primitives;

public class Axis3 extends Line3 {
	public Axis3() {
		super.setVertices(new Vector3(0, 0, 0), new Vector3(0, 0, 1));
	}

	public Axis3(Vector3 p, Vector3 d) {
		super.setVertices(p, p.add(d));
	}
}
