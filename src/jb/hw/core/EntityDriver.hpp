#ifndef _hw_core_EntityDriver
#define _hw_core_EntityDriver

#include <string>
#include <map>
#include "IDriver.h" 

using namespace std;

namespace hw{
    namespace core{

        import jb.hw.affector.ConstraintAffectorResolver;
        import jb.hw.affector.PropertyAffectorResolver;

        /**
         * EntityDriver know how each Property affect this particular Entity.
         * 
         * EntityDriver is also to delegate away some of the dynamic behaviour away
         * from the Entity object.
         */
        class EntityDriver: IDriver {
            private: 
                IPropertyResolver *pafr;
                IConstraintResolver *cafr;

                Map<string, IAffector> paftrs;
                Map<string, IAffector> caftrs;

            public:
                EntityDriver(){
                }

            private:
                void reloadAfftrs(const Entity& e) {
                    pafr = new PropertyAffectorResolver(e);
                    cafr = new ConstraintAffectorResolver(e);

                    for(Property a: e.getProperties()){
                        IAffector aff = (IAffector) a.dispatch(pafr);
                        paftrs.put(a.getType(), aff);
                    }

                    for(Constraint a: e.getConstraints()){
                        IAffector aff = (IAffector) a.dispatch(cafr);
                        caftrs.put(a.getType(), aff);
                    }
                }

                /**
                 *  Called by Entity#step, this causes evaluation of Affector on Entity 
                 *  Property.
                 *  	 
                 *  @param e
                 */
            public:
                void drive(Entity *e) {
                    if (pafr == null || cafr == null){
                        reloadAfftrs(e);
                    }

                    // update Property changes - each individual property
                    IAffector aff = null;
                    for(Property a: e.getProperties()){
                        aff = paftrs.get(a.getType());
                        if (aff!=null) {
                            // System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
                            aff.affect((IAffectable) a, e);
                        }
                    }

                    // update Constraint changes - each individual property
                    for(Constraint a: e.getConstraints()){
                        aff = paftrs.get(a.getType());
                        if (aff!=null) {
                            // System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
                            aff.affect((IAffectable) a, e);
                        }
                    }

                    // update ensemble
                    for(Entity en: e.getEnsemble()){
                        en.step();
                    }
                }

        };
    }
}
#endif
