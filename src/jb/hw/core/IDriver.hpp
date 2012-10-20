#ifndef _hw_core_IDriver
#define _hw_core_IDriver

namespace hw{
    namespace core{

        class Entity;

        class IDriver {
            public:
                virtual void drive(Entity *e);
        };
    }
}
#endif
