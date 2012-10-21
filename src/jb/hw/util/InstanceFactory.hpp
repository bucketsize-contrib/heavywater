#ifndef _hw_core_InstanceFactory
#define _hw_core_InstanceFactory

#include <string>
#include <map>

using namespace std;

namespace hw{
    namespace affector{

        class InstanceFactory {
            private:
                /*
                static map<string, Class<?>> classPool = new map<string, Class<?>>();
                static map<string, Object> instancePool = new map<string, Object>();
                */
            public:
                static void *getInstance(string klass){
                    /*
                    Class<?> k = classPool.get(klass);
                    if (k==null){
                        try {
                            k = Class.forName(klass);
                            classPool.put(klass, k);
                        } catch (ClassNotFoundException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    try {
                        return k.newInstance();
                    } catch (InstantiationException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    */
                    return NULL;
                }


                static void *getCachedInstance(string klass){
                    /*
                    Object i = instancePool.get(klass);
                    if (i==null){
                        i = getInstance(klass);
                        instancePool.put(klass, i);
                    }
                    */
                    return NULL;
                }

        };
    }
}
#endif
