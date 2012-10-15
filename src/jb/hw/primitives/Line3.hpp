#ifndef _Line3
#define _Line3

#include "IPrimitive.h"

namespace hw {
namespace primitives {

class Line3: IPrimitive {

protected:
	Vector3 v[];

public:
	Line3() {
		v = new Vector3 [] { new Vector3(), new Vector3() };
	}

	Line3(double xa, double ya, double za, double xb, double yb,
			double zb) {
		this();
		v[0] = new Vector3(xa, ya, za);
		v[1] = new Vector3(xb, yb, zb);
	}

	Line3(Vector3 v1, Vector3 v2) {
		this();
		setVertices(v1, v2);
	}

	void setLine(double xa, double ya, double za, double xb, double yb,
			double zb) {
		v[0].setX(xa);
		v[0].setY(ya);
		v[0].setZ(za);
		v[1].setX(xb);
		v[1].setY(yb);
		v[1].setZ(zb);
	}

	Vector3& vertices() {
		return v;
	}

	void setVertices(Vector3 v1, Vector3 v2) {
		v[0] = v1;
		v[1] = v2;
	}

	string notation() {
		return "(Line3 " + v[0].notation() + " "
				+ v[1].notation() + ")";
	}

	//
	// pluggable OPS
	//
	// only for this Line3 rep
	double length() {
		return this->vertices()[1].sub(this->vertices()[0]).length();

	}

	// only for this Line3 rep
	double lengthSQ() {
		return this->vertices()[1].sub(this->vertices()[0]).lengthSQ();

	}

	// only for this Line3 rep
	Vector3 center(Line3 l) {
		return ((l.vertices()[0].add(l.vertices()[1]))
				.mult((double) 0.5f));
	}

	Vector3 axisVector() {
		return (this->vertices()[1].sub(this->vertices()[0]));
	}

	bool isPointBetweenStartAndEnd(Line3 l, Vector3 point) {
		return point.isBetweenPoints(l.vertices()[0], l.vertices()[1]);
	}

	Vector3 proximalPoint(Vector3 point) {
		Vector3 c = point.sub(this->vertices()[0]);
		Vector3 tv = this->vertices()[1].add(this->vertices()[0]);
		double d = (double) tv.length();
		tv.mult(1.0f / d);
		double t = tv.dot(c);

		if (t < (double) 0.0)
			return this->vertices()[0];
		if (t > d)
			return this->vertices()[1];

		tv = tv.mult(t);

		return this->vertices()[0].add(tv);
	}

	Vector3 intercept(Line3 l2) {
		Vector3 c = this->vertices()[0].sub(l2.vertices()[0]);
		Vector3 a = this->axisVector();
		Vector3 b = l2.axisVector();

		if (c.cross(a).normalize().isParallel(c.cross(b).normalize())) {
			double m = c.cross(b).length() / a.cross(b).length();
			return this->vertices()[0].add(a.mult(m));
		} else {
			logInfo(this->notation() + " " + l2.notation()
					+ " do not intersect");
			return null;
		}
	}

	double interceptAngle(Line3 l2) {
		if (this->intercept(l2) != null) {
			Vector3 a = this->axisVector();
			Vector3 b = l2.axisVector();
			return asin(a.cross(b).length() / (a.length() * b.length()));
		}
		return 0;
	}

};
}
}
#endif
