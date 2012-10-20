#ifndef _hw_core_Constraint
#define _hw_core_Constraint

#include "Base.hpp"
#include "IVisitable.hpp"
#include "IAffectable.hpp"

namespace hw{
    namespace core{
        // Constrains are
        // - Force
        // - Reactive Force
        // - Torque
        // - Reactive Torque
        // - Field
        // - PlayBack
        // - AI
        // directly effects Dynamics
        // is affected by other Property(s)
        class Constraint: public Base,  public IVisitable, public IAffectable{
        };
    }
}
#endif
