#include "EntityDriver.hpp"

namespace hw{
    namespace core{

        EntityDriver::EntityDriver(){
        }

        void EntityDriver::reloadAfftrs(const Entity& e) {
            pafr = new PropertyAffectorResolver(e);
            cafr = new ConstraintAffectorResolver(e);

            vector<Property *> *vpp = e.getProperties();
            for(vector<Property>::iterator it=vpp->begin(); 
                    it != vpp->end();
                    ++it)
            {
                IAffector *aff = (IAffector *) it->dispatch(pafr);
                paftrs.put(it->getType(), aff);
            }

            vector<Constraint *> *vcp = e.getConstraints();
            for(vector<Constraint *>::iterator it = vcp->begin();
                    it != vcp->end();
                    ++it)
            {
                IAffector *aff = (IAffector *) it->dispatch(cafr);
                caftrs.put(it->getType(), aff);
            }
        }

        /**
         *  Called by Entity#step, this causes evaluation of Affector on Entity 
         *  Property.
         *  	 
         *  @param e
         */

        void EntityDriver::drive(Entity *e) {
            if (pafr == nullptr || cafr == nullptr){
                reloadAfftrs(*e);
            }

            // update Property changes - each individual property
            IAffector *aff = nullptr;

            vector<Property *> *vpp = e->getProperties();
            for(vector<Property>::iterator it=vpp->begin(); 
                    it != vpp->end();
                    ++it)
            {
                aff = paftrs.get(it->getType());
                if (aff!=nullptr) {
                    // System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
                    aff->affect((IAffectable *) it, e);
                }
            }

            // update Constraint changes - each individual property
            vector<Constraint *> *vcp = e->getConstraints();
            for(vector<Constraint *>::iterator it = vcp->begin();
                    it != vcp->end();
                    ++it)
            {
                aff = paftrs.get(it->getType());
                if (aff!=nullptr) {
                    // System.out.printf("compute %s on %s, id=%d\n", p.getType(), e.getType(), e.getID());
                    aff.affect((IAffectable *) it, e);
                }
            }

            // update ensemble
            vector<Entity *> *vep = e->getEnsemble();
            for(vector<Constraint *>::iterator it = vcp->begin();
                    it != vcp->end();
                    ++it)
            {
                it->step();
            }
        }
    }
}
