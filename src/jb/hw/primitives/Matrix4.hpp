#ifndef _Matrix4
#define _Matrix4

#include "IPrimitive.hpp"
#include "MArray.hpp"
#include "Quaternion.hpp"
#include <iostream>
#include <sstream>

namespace hw {
    namespace primitives {

        class Matrix4: IPrimitive {
            private:
                double m[][4];
                /*
                   = { { 1, 0, 0, 0 }, 
                   { 0, 1, 0, 0 }, 
                   { 0, 0, 1, 0 },
                   { 0, 0, 0, 1 } };
                   */
            public:
                Matrix4() {
                }

                Matrix4(double m2[][4]) {
                    this->setArray(m2);
                }

                Matrix4& setArray(double m[4][4]) {
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            this->m[i][j] = m[i][j];
                    return *this;
                }

                double* array() {
                    return m;
                }

                void setElement(int i, int j, double x) {
                    m[i][j] = x;
                }

                double element(int i, int j) {
                    return m[i][j];
                }

                Matrix4& equal(Matrix4& m2) {
                    this->setArray(m2.array());
                    return *this;
                }

                Matrix4& setAsIdentity() {
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            if (i == j)
                                this->m[i][j] = 1;
                            else
                                this->m[i][j] = 0;
                    return *this;
                }

                string notation() {
                    ostringstream ss;
                    ss << "(Matrix4 ";
                    double  a[][4]; a = m;
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

                Matrix4& mult(double s) {
                    Matrix4 *m1 = new Matrix4();
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            m1->setElement(i, j, this->Element(i, j) * s);
                    return *m1;
                }

                Quaternion& mult(Quaternion& v) {
                    double v2[4] = v.array();
                    double v1[4];
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            v1[i] += this->Element(i, j) * v2[j];
                    return *(new Quaternion(v1));
                }

                Matrix4& mult(Matrix4& m2) {
                    double a2[][4] = m2.array();
                    double r2[][] = new double[4][4];
                    for (int i = 0; i < 4; ++i)
                        for (int j = 0; j < 4; ++j)
                            for (int k = 0; k < 4; ++k)
                                r2[i][j] += this->Element(i, j) * a2[k][j];
                    return *(new Matrix4(r2));
                }

        };
    }
}
#endif

