#ifndef _hw_core_IVisitable
#define _hw_core_IVisitable

#include "IResolver.hpp"

namespace hw{
    namespace core{

        class IVisitable{
            public:
                virtual void* dispatch(IResolver r)=0;
        };
    }
}
#endif
