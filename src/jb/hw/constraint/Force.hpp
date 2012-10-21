#ifndef _hw_core_Force 
#define _hw_core_Force 

#include <string>
#include "../primitives/Vector3.hpp"
#include "../core/Constraint.hpp"
#include "../core/IResolver.hpp"
#include "../core/IConstraintResolver.hpp"

using namespace std;
using namespace hw::primitives;
using namespace hw::core;
using namespace hw::constraint;

namespace hw{
    
    namespace core{
        class Entity;
    }
    
    namespace constraint{

        class Force: public Constraint{

            private:
                Vector3 origin;
                Vector3 vector;

            public:
                Force(const Vector3& o, const Vector3& v){
                    origin.copy(o);
                    vector.copy(v);
                }

                string inspect() {
                    // TODO Auto-generated method stub
                    return NULL;
                }

                virtual void *dispatch(const IResolver &r) {
                    IConstraintResolver &cr = static_cast<IConstraintResolver &>
                        ( const_cast<IResolver &>( r ) );

                        return cr.resolve( this );
                }
        };
    }
}
#endif
