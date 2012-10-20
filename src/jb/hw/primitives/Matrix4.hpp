#ifndef _Matrix4
#define _Matrix4

#include "IPrimitive.hpp"
#include "Quaternion.hpp"
#include "types.h"
#include <iostream>
#include <sstream>

namespace hw {
    namespace primitives {

        class Matrix4: IPrimitive {
            private:
                double m[4][4];
                /*
                  = { { 1, 0, 0, 0 }, 
                   { 0, 1, 0, 0 }, 
                   { 0, 0, 1, 0 },
                   { 0, 0, 0, 1 } };
                   */
            public:
                Matrix4() {
                }

                Matrix4(const rArray_d4x4 m) {
                    this->setArray(m);
                }

                Matrix4* setArray(const rArray_d4x4 m) {
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            this->m[i][j] = m[i][j];
                    return this;
                }

                pArray_d4x4 array() const {
                    return (pArray_d4x4) m;
                }

                void setElement(int i, int j, double x) {
                    m[i][j] = x;
                }

                double element(int i, int j) const {
                    return m[i][j];
                }

                Matrix4* copy(const Matrix4& m){ 

                    this->setArray((rArray_d4x4)*(m.array()) );
                    return this;
                }

                Matrix4* setAsIdentity() {
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            if (i == j)
                                this->m[i][j] = 1;
                            else
                                this->m[i][j] = 0;
                    return this;
                }

                virtual string notation() {
                    ostringstream ss;
                    ss << "(Matrix4 ";
                    double  (*a)[4]; a = m;
                    for (int i = 0; i < 4; ++i){
                        ss << "\n(";
                        for (int j = 0; j < 4; ++j){
                            ss << a[i][j]; ss << " ";				
                        }
                        ss << ")";
                    }
                    ss << ")";
                    return ss.str();
                }

                Matrix4* mult(double s) const {
                    Matrix4 *m1 = new Matrix4();
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            m1->setElement(i, j, this->element(i, j) * s);
                    return m1;
                }

                Quaternion* mult(const Quaternion& v) const {
                    double *v2 = v.array();
                    double *v1;
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            v1[i] += this->element(i, j) * v2[j];
                    return new Quaternion(v1);
                }

                Matrix4* mult(const Matrix4& m2) const {
                    double (*a2)[4] = m2.array();
                    double (*r2)[4]; 
                    r2 = new double[4][4];
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            for (int k = 0; k < 4; ++k)
                                r2[i][j] += this->element(i, j) * a2[k][j];
                    return new Matrix4((rArray_d4x4)r2);
                }

        };
    }
}
#endif

