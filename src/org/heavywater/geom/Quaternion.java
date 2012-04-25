package org.heavywater.geom;

//	Quaternion 
//		H = a.1 + x.i + y.j + z.k  	or	[a x y z]
//		where,
//			ijk = -1
//			j, j, k => basis of the quaternion
//		also,
//			H = |z 				w|
//				|-cj(q)		cj(z)|
//			
//				cj() => conjugate of
//					
//				z= a+ib; w= c+id
//	
//		also,
//			I = |i	0|
//				|0 -1|
//				
//			J = |0 	1|
//				|-1 0|
//				
//			K = |0 	i|
//				|i 	0|
//			I^2 = -U
//			J^2 = -U
//			K^2 = -U
//			U^2 = -1
//
//	Hamiltonian rule:
//		1 = | 1  0  0  0 |
//			| 0  1  0  0 |
//			| 0  0  1  0 |
//			| 0  0  0  1 |
//	
//		i = | 0  1  0  0 |
//			|-1  0  0  0 |
//			| 0  0  0  1 |
//			| 0  0 -1  0 |
//		
//		j = | 0  0  0 -1 |
//			| 0  0 -1  0 |
//			| 0  1  0  0 |
//			| 1  0  0  0 |
//	
//		k = | 1  0 -1  0 |
//			| 0  0  0  1 |
//			| 1  0  0  0 |
//			| 0 -1  0  0 |
//		then,
//			ijk=-1
//			ij = -ji = k
//			jk = -kj = i
//			ki = -ik = j
//		or,
//		multiplication table for quaternion basis
//			    1  i  j  k
//			  +------------
//			1 | 1  i  j  k
//			i | i -1  k -j
//			j | j -k -1  i
//			k | k  j -i -1

//	prop:
//		H1*H2 =/= H2*H1
//	
//		H = [a x y z] ;one real, 3 imaginary
//
//		i =/= j =/= k ;3 square roots of -1

//	Uses:
//		representing orientations and rotations
//		other:
//			simpler to compose than euler angles
//			efficient than matrixes

public class Quaternion extends Geom {

	private double[] c = { 1, 0, 0, 0 };

	//
	// Basic OPS
	//
	public Quaternion() {

	}

	public Quaternion(double a, double i, double j, double k) {

		c[1] = i;
		c[2] = j;
		c[3] = k;
		c[0] = a;
	}

	public Quaternion(double[] _c) {

		c[0] = _c[0];
		c[1] = _c[1];
		c[2] = _c[2];
		c[3] = _c[3];

	}

	public void setVector3(Vector3 v2) {
		c[1] = v2.getX();
		c[2] = v2.getY();
		c[3] = v2.getZ();
		c[0] = 1.0f;
	}

	public Vector3 getVector3() {
		return new Vector3(c[1], c[2], c[3]);
	}

	public double[] getAsArray() {
		return c;
	}

	public void setAsArray(double[] _c) {
		c[0] = _c[0];
		c[1] = _c[1];
		c[2] = _c[2];
		c[3] = _c[3];
	}

	public double getX() {
		return c[1];
	}

	public double getY() {
		return c[2];
	}

	public double getZ() {
		return c[3];
	}

	public double getW() {
		return c[0];
	}

	public void setX(double c) {
		this.c[1] = c;
	}

	public void setY(double c) {
		this.c[2] = c;
	}

	public void setZ(double c) {
		this.c[3] = c;
	}

	public void setW(double c) {
		this.c[0] = c;
	}

	//
	// Pluggable OPS
	//
	public Quaternion add(Quaternion q2) {
		return new Quaternion(this.getW() + q2.getW(), this.getX() + q2.getX(),
				this.getY() + q2.getY(), this.getZ() + q2.getZ());

	}

	public Quaternion sub(Quaternion q2) {
		return new Quaternion(this.getW() - q2.getW(), this.getX() - q2.getX(),
				this.getY() - q2.getY(), this.getZ() - q2.getZ());

	}

	public Quaternion mult(double s) {
		return new Quaternion(this.getW() * s, this.getX() * s,
				this.getY() * s, this.getZ() * s);

	}

	public Quaternion mult(Quaternion q2) {
		return new Quaternion(this.getX() * q2.getW() + this.getY() * q2.getZ()
				- this.getZ() * q2.getY() + this.getW() * q2.getX(),
				-this.getX() * q2.getZ() + this.getY() * q2.getW()
						+ this.getZ() * q2.getX() + this.getW() * q2.getY(),
				this.getX() * q2.getY() - this.getY() * q2.getX() + this.getZ()
						* q2.getW() + this.getW() * q2.getZ(), -this.getX()
						* q2.getX() - this.getY() * q2.getY() - this.getZ()
						* q2.getZ() + this.getW() * q2.getW());
	}

	public Quaternion normalise(Quaternion q1) {
		double n = Math.sqrt(q1.getX() * q1.getX() + q1.getY() * q1.getY()
				+ q1.getZ() * q1.getZ() + q1.getW() * q1.getW());
		return this.mult(1.0f / n);
	}

	public Quaternion conjugate(Quaternion q1) {
		return new Quaternion(-q1.getW(), -q1.getX(), -q1.getY(), q1.getZ());
	}

}
