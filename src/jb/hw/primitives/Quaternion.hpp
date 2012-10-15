#ifndef _Quaternion
#define _Quaternion

#include "IPrimitive.h"

namespace hw {
namespace primitives {



//	Quaternion 
//		H = a.1 + x.i + y.j + z.k  	or	[a x y z]
//		where,
//			ijk = -1
//			j, j, k => basis of the quaternion
//		also,
//			H = |z 				w|
//				|-cj(w)		cj(z)|
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
//			ijk= -1
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

class Quaternion: IPrimitive {

private :
	double c[];

public:
	Quaternion() {
		c = new double[] { 1, 0, 0, 0 };
	}

	Quaternion(double a, double i, double j, double k) {
		this();
		c[1] = i;
		c[2] = j;
		c[3] = k;
		c[0] = a;
	}

	Quaternion(double[] _c) {
		this();
		c[0] = _c[0];
		c[1] = _c[1];
		c[2] = _c[2];
		c[3] = _c[3];

	}

	void setVector(Vector3 v2) {
		c[1] = v2.X();
		c[2] = v2.Y();
		c[3] = v2.Z();
		c[0] = 1.0f;
	}

	Vector3 vector() {
		return new Vector3(c[1], c[2], c[3]);
	}

	double[] array() {
		return c;
	}

	void setArray(double[] _c) {
		c[0] = _c[0];
		c[1] = _c[1];
		c[2] = _c[2];
		c[3] = _c[3];
	}

	double X() {
		return c[1];
	}

	double Y() {
		return c[2];
	}

	double Z() {
		return c[3];
	}

	double W() {
		return c[0];
	}

	void setX(double c) {
		this->c[1] = c;
	}

	void setY(double c) {
		this->c[2] = c;
	}

	void setZ(double c) {
		this->c[3] = c;
	}

	void setW(double c) {
		this->c[0] = c;
	}

	Quaternion add(Quaternion q2) {
		return new Quaternion(this->W() + q2.W(), this->X() + q2.X(),
				this->Y() + q2.Y(), this->Z() + q2.Z());

	}

	Quaternion sub(Quaternion q2) {
		return new Quaternion(this->W() - q2.W(), this->X() - q2.X(),
				this->Y() - q2.Y(), this->Z() - q2.Z());

	}

	Quaternion mult(double s) {
		return new Quaternion(this->W() * s, this->X() * s,
				this->Y() * s, this->Z() * s);

	}

	Quaternion mult(Quaternion q2) {
		return new Quaternion(this->X() * q2.W() + this->Y() * q2.Z()
				- this->Z() * q2.Y() + this->W() * q2.X(),
				-this->X() * q2.Z() + this->Y() * q2.W()
				+ this->Z() * q2.X() + this->W() * q2.Y(),
				this->X() * q2.Y() - this->Y() * q2.X() + this->Z()
				* q2.W() + this->W() * q2.Z(), -this->X()
				* q2.X() - this->Y() * q2.Y() - this->Z()
				* q2.Z() + this->W() * q2.W());
	}

	Quaternion normalise(Quaternion q1) {
		double n = sqrt(q1.X() * q1.X() + q1.Y() * q1.Y()
				+ q1.Z() * q1.Z() + q1.W() * q1.W());
		return this->mult(1.0f / n);
	}

	Quaternion conjugate(Quaternion q1) {
		return new Quaternion(-q1.W(), -q1.X(), -q1.Y(), q1.Z());
	}

	string notation(){
		return "(Quaternion " + c[0] + " " +c[1]+ " " + c[2] + " "
				+ c[3]+")";
	}
};
}
}
#endif
