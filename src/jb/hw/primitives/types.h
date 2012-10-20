#ifndef _types
#define _types

#include <math.h>
#include <iostream>
#include <sstream>

namespace hw {
    namespace primitives {

        typedef float (*pArray_f4x4)[4];
        typedef float (&rArray_f4x4)[4][4];
        typedef double (*pArray_d4x4)[4];
        typedef double (&rArray_d4x4)[4][4];
    }
}
#endif
