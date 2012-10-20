#ifndef _hw_core_IEntityResolver
#define _hw_core_IEntityResolver

#include "IResolver.hpp"

namespace hw{
    namespace core{

        class Engine;
        class Particle;
        class ParticleSystem;
        class StateLogger;

        class IEntityResolver: public IResolver{
            void *resolve(Engine *engine);
            void *resolve(Particle *particle);
            void *resolve(ParticleSystem *particleSystem);
            void *resolve(StateLogger *stateLogger);
        };
    }
}
#endif

