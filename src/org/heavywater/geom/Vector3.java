package org.heavywater.geom;

import org.heavywater.util.FNotation;

// Mathlib Foundation classes

// usability: 
//	computer vision, 
//	robotics, 
//	navigation, 
//	general kinematics and mechanics

public class Vector3 extends Geom {
	private double[] c = { 0, 0, 0 };

	//
	// Basic OPS
	//
	public Vector3() {
		c[0] = c[1] = c[2] = 0;
	}

	public Vector3(double x, double y, double z) {
		c[0] = x;
		c[1] = y;
		c[2] = z;
	}

	public Vector3(Vector3 vec) {
		this.equal(vec);
	}

	public void equal(Vector3 vec) {
		c[0] = vec.c[0];
		c[1] = vec.c[1];
		c[2] = vec.c[2];
	}

	public double getX() {
		return c[0];
	}

	public void setX(double x) {
		c[0] = x;
	}

	public double getY() {
		return c[1];
	}

	public void setY(double y) {
		c[1] = y;
	}

	public double getZ() {
		return c[2];
	}

	public void setZ(double z) {
		c[2] = z;
	}

	public double[] getAsArray() {
		return this.c;
	}

	public boolean isZero() {
		if (c[0] == 0 && c[1] == 0 && c[2] == 0)
			return true;
		else
			return false;
	}

	public boolean isEqual(Vector3 v) {
		if (v.getX() == c[0] && v.getY() == c[1] && v.getZ() == c[2])
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
		return new Vector3(this.getX() + v1.getX(), this.getY() + v1.getY(),
				this.getZ() + v1.getZ());

	}

	public Vector3 sub(Vector3 v1) {
		return new Vector3(this.getX() - v1.getX(), this.getY() - v1.getY(),
				this.getZ() - v1.getZ());

	}

	public Vector3 mult(double scale) {
		return new Vector3(this.getX() * scale, this.getY() * scale,
				this.getZ() * scale);

	}

	public double length() {
		return Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY()
				+ this.getZ() * this.getZ());
	}

	public double lengthSQ() {
		return this.getX() * this.getX() + this.getY() * this.getY()
				+ this.getZ() * this.getZ();
	}

	public double dot(Vector3 v1) {
		return this.getX() * v1.getX() + this.getY() * v1.getY() + this.getZ()
				* v1.getZ();
	}

	public Vector3 cross(Vector3 v1) {
		return new Vector3(this.getY() * v1.getZ() - this.getZ() * v1.getY(),
				this.getZ() * v1.getX() - this.getX() * v1.getZ(), this.getX()
						* v1.getY() - this.getY() * v1.getX());
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
