#ifndef _SMatrix
#define _SMatrix

namespace hw{
    namespace primitives{
        template<class T, int r, int c>
            class SMatrix{
                public:
                    MArray(){}
                    T array[r][c];


            };
    }
}

#endif

