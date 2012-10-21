#ifndef _hw_core_EntityDriver
#define _hw_core_EntityDriver

#include <string>
#include <map>
#include <vector>
#include "Entity.hpp"
#include "IDriver.hpp" 
#include "IPropertyResolver.hpp"
#include "IConstraintResolver.hpp"
#include "IAffector.hpp"
using namespace std;

namespace hw{
    namespace core{
        /**
         * EntityDriver know how each Property affect this particular Entity.
         * 
         * EntityDriver is also to delegate away some of the dynamic behaviour away
         * from the Entity object.
         */
        class EntityDriver: IDriver {
            private: 
                IPropertyResolver *pafr;
                IConstraintResolver *cafr;

                map<string, IAffector *> paftrs;
                map<string, IAffector *> caftrs;

            public:
                EntityDriver();

            private:
                void reloadAfftrs(const Entity& e);

            public:
                /**
                 *  Called by Entity#step, this causes evaluation of Affector on Entity 
                 *  Property.
                 *  	 
                 *  @param e
                 */

                void drive(Entity *e);

        };
    }
}
#endif
