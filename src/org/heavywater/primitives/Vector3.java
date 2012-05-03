package org.heavywater.primitives;

import org.heavywater.util.FNotation;

public class Vector3 extends Geom {
	private double[] c;

	public Vector3(){
		c = new double [] { 0, 0, 0 };
	}

	public Vector3(double x, double y, double z) {
		this();
		c[0] = x;
		c[1] = y;
		c[2] = z;
	}

	public Vector3(Vector3 vec) {
		this();
		this.copy(vec);
	}

	public void copy(Vector3 vec) {
		c[0] = vec.c[0];
		c[1] = vec.c[1];
		c[2] = vec.c[2];
	}

	public double X() {
		return c[0];
	}

	public void setX(double x) {
		c[0] = x;
	}

	public double Y() {
		return c[1];
	}

	public void setY(double y) {
		c[1] = y;
	}

	public double Z() {
		return c[2];
	}

	public void setZ(double z) {
		c[2] = z;
	}

	public double[] array() {
		return this.c;
	}

	public boolean isZero() {
		if (c[0] == 0 && c[1] == 0 && c[2] == 0)
			return true;
		else
			return false;
	}

	public boolean isEqual(Vector3 v) {
		if (v.X() == c[0] && v.Y() == c[1] && v.Z() == c[2])
			return true;
		else
			return false;
	}

	public boolean isParallel(Vector3 v) {
		if (this.cross(v).isZero())
			return true;
		else
			return false;
	}

	public String notation() {
		return FNotation.generate(this);
	}

	// extra opts
	public Vector3 add(Vector3 v1) {
		return new Vector3(this.X() + v1.X(), this.Y() + v1.Y(),
				this.Z() + v1.Z());

	}

	public Vector3 sub(Vector3 v1) {
		return new Vector3(this.X() - v1.X(), this.Y() - v1.Y(),
				this.Z() - v1.Z());

	}

	public Vector3 mult(double scale) {
		return new Vector3(this.X() * scale, this.Y() * scale,
				this.Z() * scale);

	}

	public double length() {
		return Math.sqrt(this.X() * this.X() + this.Y() * this.Y()
				+ this.Z() * this.Z());
	}

	public double lengthSQ() {
		return this.X() * this.X() + this.Y() * this.Y()
				+ this.Z() * this.Z();
	}

	public double dot(Vector3 v1) {
		return this.X() * v1.X() + this.Y() * v1.Y() + this.Z()
				* v1.Z();
	}

	public Vector3 cross(Vector3 v1) {
		return new Vector3(this.Y() * v1.Z() - this.Z() * v1.Y(),
				this.Z() * v1.X() - this.X() * v1.Z(), this.X()
						* v1.Y() - this.Y() * v1.X());
	}

	public boolean isBetweenPoints(Vector3 v0, Vector3 v1) {
		double f = v1.sub(v0).lengthSQ();
		return this.sub(v0).lengthSQ() <= f && this.sub(v1).lengthSQ() <= f;
	}

	public Vector3 normalize() {
		if (this.length() != 0.0f) {
			return this.mult(1.0f / this.length());
		} else {
			return this;
		}
	}

	public double angle(Vector3 v1) {
		return Math.acos(this.dot(v1) / (this.length() * v1.length()));
	}

}
