#ifndef _hw_core_IAffector
#define _hw_core_IAffector

#include <vector>
#include "IAffectable.hpp"

using namespace std;

namespace hw{
    namespace core{

        class Entity;

        class IAffector {
            public:
                virtual void affect(IAffectable *p, Entity *e)=0;
                virtual IAffectable *aggregate(vector<IAffectable *> *lp)=0;
        };

    }

}
#endif
