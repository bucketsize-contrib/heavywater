#ifndef _CFrame
#define _CFrame

#include "IPrimitive.hpp"
#include "Vector3.hpp"
#include "Matrix4.hpp"
#include <sstream>

using namespace std;

namespace hw {
    namespace primitives {

        class CFrame: IPrimitive {

            private:
                Vector3 ux;
                Vector3 uy;
                Vector3 uz;
                Vector3 p;
                Matrix4 t;

            public:
                CFrame() {
                    // default matrix init
                }

                Vector3 X() {
                    return ux;
                }

                void setX(Vector3& ux) {
                    this->ux.copy(ux);
                }

                Vector3& Y() {
                    return uy;
                }

                void setY(Vector3& uy) {
                    this->uy.copy(uy);
                }

                Vector3& Z() {
                    return uz;
                }

                void setZ(Vector3& uz) {
                    this->uz.copy(uz);
                }

                Vector3& position() {
                    return p;
                }

                void setPos(Vector3& pos) {
                    this->p = new Vector3(pos);
                }

                Matrix4& transform() {
                    return t;
                }

                void setTransform(Matrix4& transform) {
                    this->t.equal(transform);
                }

                string notation() {
                    // TODO Auto-generated method stub
                    ostringstream ss;
                    ss << "(CFrame ";
                    ss << ux.notation();
                    ss << uy.notation();
                    ss << uz.notation();
                    ss << p.notation();
                    ss << ")";
                    return ss.str();
                }

        };
    }
}
#endif
