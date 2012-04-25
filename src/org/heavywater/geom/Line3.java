package org.heavywater.geom;

import org.heavywater.util.FNotation;

// line is two points
// spec:
//		 v[0], v[1] just 2 points
//	or,	 v[0], v[1] start and end point or line seg

public class Line3 extends Geom {

	protected Vector3[] v = { null, null };

	//
	// basic OPS
	//
	public Line3() {
		v[0] = new Vector3();
		v[1] = new Vector3(0, 1, 0);
	}

	public Line3(double xa, double ya, double za, double xb, double yb,
			double zb) {
		v[0] = new Vector3(xa, ya, za);
		v[1] = new Vector3(xb, yb, zb);
	}

	public Line3(Vector3 v1, Vector3 v2) {
		setVertices(v1, v2);
	}

	public void setLine(double xa, double ya, double za, double xb, double yb,
			double zb) {
		v[0].setX(xa);
		v[0].setY(ya);
		v[0].setZ(za);
		v[1].setX(xb);
		v[1].setY(yb);
		v[1].setZ(zb);
	}

	public Vector3[] getVertices() {
		return v;
	}

	public void setVertices(Vector3 v1, Vector3 v2) {
		v[0] = v1;
		v[1] = v2;
	}

	public String notation() {
		return FNotation.generate(this);
	}

	//
	// pluggable OPS
	//
	// only for this Line3 rep
	public double length() {
		return this.getVertices()[1].sub(this.getVertices()[0]).length();

	}

	// only for this Line3 rep
	public double lengthSQ() {
		return this.getVertices()[1].sub(this.getVertices()[0]).lengthSQ();

	}

	// only for this Line3 rep
	public Vector3 center(Line3 l) {
		return ((l.getVertices()[0].add(l.getVertices()[1]))
				.mult((double) 0.5f));
	}

	public Vector3 axisVector() {
		return (this.getVertices()[1].sub(this.getVertices()[0]));
	}

	public boolean isPointBetweenStartAndEnd(Line3 l, Vector3 point) {
		return point.isBetweenPoints(l.getVertices()[0], l.getVertices()[1]);
	}

	public Vector3 proximalPoint(Vector3 point) {
		Vector3 c = point.sub(this.getVertices()[0]);
		Vector3 tv = this.getVertices()[1].add(this.getVertices()[0]);
		double d = (double) tv.length();
		tv.mult(1.0f / d);
		double t = tv.dot(c);

		if (t < (double) 0.0)
			return this.getVertices()[0];
		if (t > d)
			return this.getVertices()[1];

		tv = tv.mult(t);

		return this.getVertices()[0].add(tv);
	}

	public Vector3 intercept(Line3 l2) {
		Vector3 c = this.getVertices()[0].sub(l2.getVertices()[0]);
		Vector3 a = this.axisVector();
		Vector3 b = l2.axisVector();

		if (c.cross(a).normalize().isParallel(c.cross(b).normalize())) {
			double m = c.cross(b).length() / a.cross(b).length();
			return this.getVertices()[0].add(a.mult(m));
		} else {
			System.out.println(this.notation() + " " + l2.notation()
					+ " do not intersect");
			return null;
		}
	}

	public double interceptAngle(Line3 l2) {
		if (this.intercept(l2) != null) {
			Vector3 a = this.axisVector();
			Vector3 b = l2.axisVector();
			return Math.asin(a.cross(b).length() / (a.length() * b.length()));
		}
		return 0;
	}

}