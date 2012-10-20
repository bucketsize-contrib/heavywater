#ifndef _hw_core_IPropertyResolver
#define _hw_core_IPropertyResolver

#include "IResolver.hpp"

namespace hw{
    namespace core{

        class Dynamics;
        class ElectoStatic;
        class Geometry;
        class Inertial;
        class Kinetics;

        class IPropertyResolver: public IResolver{
            void *resolve(Dynamics *d);
            void *resolve(Kinetics *k);
            void *resolve(ElectoStatic *e);
            void *resolve(Geometry *g);
            void *resolve(Inertial *i);
        };
    }
}
#endif
