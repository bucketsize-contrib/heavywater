#include "Entity.hpp"

namespace hw{
    namespace core{

        Entity::Entity(){
            Entity(new EntityDriver());
        }
        Entity::Entity(EntityDriver *ed) {
            driver = ed;
            parent = NULL;
            cycleTime = 0.0;
            aliveTime = 0.0;
            //properties = new ArrayList<Property>();
            //constraints = new ArrayList<Constraint>();
            //ensemble = new ArrayList<Entity>();
            cout << "new " << type << ", id= " << id;
        }

        void Entity::driver(EntityDriver *ed) {
            driver = ed;
        }

        void Entity::step() {
            driver->drive(this);
            aliveTime += cycleTime;
        }

        void Entity::cycleTime(double t) const {
            cycleTime = t;
        }

        double Entity::getCycleTime() const {
            return cycleTime;
        }

        double Entity::getAliveTime() const {
            return aliveTime;
        }

        // -- ACCESSORS --
        void Entity::add(const Entity& e) {
            e.parent = this;
            e.cycleTime = e.cycleTime!=0.0?e.cycleTime:cycleTime;		
            ensemble.add( &e );
        }

        void Entity::add(const Property& p) {
            properties.add( &p );
        }

        void Entity::add(const Constraint& c) {
            constraints.add( &c );
        }

        vector<Entity *> *Entity::getEnsemble() const {
            return ensemble;
        }

        vector<Property *> *Entity::getProperties() const {
            return properties;
        }

        vector<Constraint *> *Entity::getConstraints() const {
            return constraints;
        }

        vector<Entity *> *Entity::getEnsemble(const string& t) const {
            vector<Entity *> *tlist = new vector<Entity *>();
            for(vector<Entity *>::iterator it = ensemble->begin(); 
                    it != ensemble->end(); 
                    ++it)
            {
                if (it->type.equals(t)){
                    tlist->add(it);
                }
            }
            return tlist;
        }	

        vector<IAffectable *> *Entity::getProperties(const string& t) const {
            vector<IAffectable> *tlist = new vector<IAffectable *>();
            for(vector<Property *>::iterator it = properties->begin();
                    it != properties->end();
                    ++it)
            {
                if (it->getType().equals(t)){
                    tlist->add( (IAffectable *) it);
                }
            }
            return tlist;
        }

        vector<IAffectable *> *Entity::getConstraints(const string& t) {
            vector<IAffectable *> *tlist = new vector<IAffectable *>();
            for(vector<Constraint *>::iterator it = constraints->begin();
                    it != constraints->end();
                    ++it){
                if (it->getType().equals(t)){
                    tlist->add((IAffectable *) it);
                }
            }
            return tlist;
        }
    }
}
