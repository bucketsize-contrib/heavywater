#ifndef _hw_core_IConstraintResolver
#define _hw_core_IConstraintResolver

#include "IResolver.hpp"
//#include "../constraint/Force.hpp"
//#include "../constraint/Joint.hpp"

namespace hw{

    namespace constraint{
        class Force;
        class Joint;
    }

    namespace core{


        class IConstraintResolver: public IResolver{
            public:
                virtual void *resolve(constraint::Force *f);
                virtual void *resolve(constraint::Joint *j);
        };
    }
}
#endif
