#ifndef _hw_core_Joint
#define _hw_core_Joint

#include <string>
#include "../primitives/Vector3.hpp"
#include "../core/Constraint.hpp"
#include "../core/IResolver.hpp"
#include "../core/IConstraintResolver.hpp"

using namespace std;
using namespace hw::primitives;
using namespace hw::core;

namespace hw{
    
    namespace core{
        class Entity;
    }

    namespace constraint{

        class Joint: public Constraint{
            private:
                Entity *other;

            public:
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

