#ifndef _Vector3
#define _Vector3

#include "IPrimitive.hpp"

#include <math.h>
#include <iostream>
#include <sstream>

namespace hw {
    namespace primitives {

        class Vector3: IPrimitive {
            private:
                double *c;
                bool valid;

            public:
                
                Vector3() {
                    c = new double[3];
                    valid = true;
                }

                Vector3(bool c):valid(c){}

                Vector3(double x, double y, double z) {
                    c[0] = x;
                    c[1] = y;
                    c[2] = z;
                }

                Vector3(const Vector3& vec) {
                    this->copy(vec);
                }

                void copy(const Vector3& vec) {
                    c[0] = vec.c[0];
                    c[1] = vec.c[1];
                    c[2] = vec.c[2];
                }

                double X() const {
                    return c[0];
                }

                void setX(double x) {
                    c[0] = x;
                }

                double Y() const {
                    return c[1];
                }

                void setY(double y) {
                    c[1] = y;
                }

                double Z() const {
                    return c[2];
                }

                void setZ(double z) {
                    c[2] = z;
                }

                double* array() const {
                    return this->c;
                }

                bool isZero() {
                    if (c[0] == 0 && c[1] == 0 && c[2] == 0)
                        return true;
                    else
                        return false;
                }

                bool isEqual(const Vector3& v) {
                    if (v.X() == c[0] && v.Y() == c[1] && v.Z() == c[2])
                        return true;
                    else
                        return false;
                }

                bool isParallel(const Vector3& v) {
                    if (this->cross(v)->isZero())
                        return true;
                    else
                        return false;
                }

                virtual string notation(){
                    ostringstream ss;
                    ss << "(Vector3 ";
                    ss << c[0];
                    ss << " ";
                    ss << c[1];
                    ss << " ";
                    ss << c[2];
                    ss << ")";
                    return ss.str();
                }

                // extra opts
                Vector3* add(const Vector3& v1) const {
                    return new Vector3(
                            this->X() + v1.X(), 
                            this->Y() + v1.Y(),
                            this->Z() + v1.Z());
                }

                Vector3* sub(const Vector3& v1) const {
                    return new Vector3(
                            this->X() - v1.X(), 
                            this->Y() - v1.Y(),
                            this->Z() - v1.Z());
                }

                Vector3* mult(double scale) const {
                    return new Vector3(
                            this->X() * scale, 
                            this->Y() * scale, 
                            this->Z() * scale);

                }

                double length() const {
                    return sqrt(
                            this->X() * this->X() + this->Y() * this->Y() + this->Z() * this->Z());
                }

                double lengthSQ() const {
                    return this->X() * this->X() + this->Y() * this->Y() + this->Z() * this->Z();
                }

                double dot(const Vector3& v1) const {
                    return this->X() * v1.X() + this->Y() * v1.Y() + this->Z() * v1.Z();
                }

                Vector3* cross(const Vector3& v1) const {
                    return new Vector3(
                            this->Y() * v1.Z() - this->Z() * v1.Y(),
                            this->Z() * v1.X() - this->X() * v1.Z(),
                            this->X() * v1.Y() - this->Y() * v1.X());
                }

                bool isBetweenPoints(const Vector3& v0, const Vector3& v1) const {
                    double f = v1.sub(v0)->lengthSQ();
                    return this->sub(v0)->lengthSQ() <= f && this->sub(v1)->lengthSQ() <= f;
                }

                Vector3* normalize() const {
                    if (this->length() != 0.0f) {
                        return this->mult(1.0f / this->length());
                    } else {
                        return const_cast<Vector3 *>(this);
                    }
                }

                double angle(const Vector3& v1) {
                    return acos(this->dot(v1) / (this->length() * v1.length()));
                }

        };
    }
}
#endif