#ifndef _hw_core_Base
#define _hw_core_Base

#include <string>

using namespace std;

namespace hw{
    namespace core{

        class Base {
            protected:
                static int pIndex;
                int id;
                string type;

            public:
                Base(){
                    id = pIndex++;
                }

                long getID() {
                    return id;
                }

                virtual string getType();

                virtual string inspect();

        };
    }
}
#endif
