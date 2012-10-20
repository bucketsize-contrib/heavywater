#ifndef _hw_core_Property
#define _hw_core_Property

#include "Base.hpp"
#include "IVisitable.hpp"
#include "IAffectable.hpp"

namespace hw{
    namespace core{
        /**
         * Property as of now only signifies physical properties an Entity can have.
         * Behaviour is tied to entity based on properties it holds, not on type.
         */
        class Property: public Base, public IVisitable, public IAffectable{
        };
    }
}
#endif
