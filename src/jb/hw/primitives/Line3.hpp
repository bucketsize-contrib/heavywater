#ifndef _Line3
#define _Line3

#include "IPrimitive.hpp"
#include "Vector3.hpp"
#include <iostream>
#include <sstream>

namespace hw {
    namespace primitives {

        class Line3: IPrimitive {

            protected:
                Vector3 v[2];

            public:
                Line3(){}

                Line3(double xa, double ya, double za, double xb, double yb,
                        double zb) {
                    Line3();
                    this->setLine(xa, ya, za, xb, yb, zb);
                }

                Line3(const Vector3& v1, const Vector3& v2) {
                    Line3();
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

                Vector3* vertices() const {
                    return const_cast<Vector3 *>(v);
                }

                void setVertices(const Vector3& v1, const Vector3& v2) {
                    v[0] = v1;
                    v[1] = v2;
                }

                virtual string notation() {
                    ostringstream ss;
                    ss << "(Line3 "; ss << v[0].notation(); ss << " "; ss << v[1].notation(); ss << ")";
                    return ss.str();

                }

                //
                // pluggable OPS
                //
                // only for this Line3 rep
                double length() const {
                    return v[1].sub(&v[0])->length();

                }

                // only for this Line3 rep
                double lengthSQ() const {
                    return v[1].sub(&v[0])->lengthSQ();

                }

                // only for this Line3 rep
                Vector3* center(const Line3& l) const {
                    return (l.vertices()[0].add(l.vertices()[1])->mult((double) 0.5f));
                }

                Vector3* axisVector() const {
                    return (v[1].sub(v[0]));
                }

                bool isPointBetweenStartAndEnd(const Line3& l, const Vector3& point) const {
                    return point.isBetweenPoints(l.vertices()[0], l.vertices()[1]);
                }

                Vector3* proximalPoint(const Vector3& point) const {
                    Vector3 *c = point.sub(v[0]);
                    Vector3 *tv = v[1].add(v[0]);
                    double d = (double) tv->length();
                    tv->mult(1.0f / d);
                    double t = tv->dot(c);

                    if (t < (double) 0.0)
                        return const_cast<Vector3 *>(&v[0]);
                    if (t > d)
                        return const_cast<Vector3 *>(&v[1]);

                    tv = tv->mult(t);

                    return v[0].add(tv);
                }

                Vector3* intercept(const Line3& l2) const {
                    Vector3 *c = v[0].sub(l2.vertices()[0]);
                    Vector3 *a = this->axisVector();
                    Vector3 *b = l2.axisVector();

                    if (c->cross(a)->normalize()->isParallel(c->cross(b)->normalize())) {
                        double m = c->cross(b)->length() / a->cross(b)->length();
                        return v[0].add(a->mult(m));
                    } else {
                        return NULL;
                    }
                }

                double interceptAngle(const Line3& l2) {
                    if (this->intercept(l2) != NULL) {
                        Vector3 *a = this->axisVector();
                        Vector3 *b = l2.axisVector();
                        return asin(a->cross(b)->length() / (a->length() * b->length()));
                    }
                    return 0;
                }

        };
    }
}
#endif
