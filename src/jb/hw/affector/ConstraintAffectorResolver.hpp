#ifndef _hw_core_ConstraintAffectorResolver 
#define _hw_core_ConstraintAffectorResolver 

#include <string>
#include "../core/IConstraintResolver.hpp"
#include "../constraint/Force.hpp"
#include "../constraint/Joint.hpp"
#include "../util/InstanceFactory.hpp"

using namespace std;
using namespace hw::core;
using namespace hw::constraint;

namespace hw{
    namespace affector{

        class ConstraintAffectorResolver: public IConstraintResolver {
            private:
                string PREFIX;
                string POSTFIX;
                Entity *e;

            public:
                ConstraintAffectorResolver(const Entity &e) {
                    this->e = const_cast<Entity *>( &e );
                    PREFIX = "jb.hw.affector.";
                    POSTFIX = "Affector";
                }

                void *resolve(const Force& f) {
                    // TODO Auto-generated method stub
                    return InstanceFactory::getInstance(PREFIX + e->getType() + f.getType()+ POSTFIX);
                }

                void *resolve(const Joint& f) {
                    // TODO Auto-generated method stub
                    return InstanceFactory::getInstance(PREFIX + e->getType() + f.getType()+ POSTFIX);
                }

        };
    }
}
#endif

