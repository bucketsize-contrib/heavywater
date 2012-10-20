#ifndef _hw_core_IPropertyResolver
#define _hw_core_IPropertyResolver

#include "IResolver.hpp"

namespace hw{
    namespace core{

        class Force;
        class Joint;

        class IConstraintResolver:public IResolver{
            void *resolve(Force *f);
            void *resolve(Joint *j);
        };
    }
}
#endif
