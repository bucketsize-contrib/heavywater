#ifndef _hw_core_Entity
#define _hw_core_Entity

#include <iostream>
#include <string>
#include <vector>

using namespace std;

namespace hw{
    namespace core{
        /**
         * Entity is the primary object in the simulation world. It can have many parts
         * also entities.
         * 
         * It has properties, that define how it behaves - flow in viscous channel, or
         * drift in a magnetic field.
         * 
         * Simulation is based around entity type and its properties [AMBI].
         * EntityDriver visits all properties.
         */

        class Entity: Base, IVisitable {	
            protected:
                vector<Property *> properties;
                vector<Constraint *> constraints;	

                vector<Entity *> ensemble;
                Entity *parent;

                double cycleTime;
                double aliveTime;

                EntityDriver *driver;

            public:
                Entity(){
                    Entity(new EntityDriver());
                }
                Entity(EntityDriver *ed) {
                    driver = ed;
                    parent = NULL;
                    cycleTime = 0.0;
                    aliveTime = 0.0;
                    //properties = new ArrayList<Property>();
                    //constraints = new ArrayList<Constraint>();
                    //ensemble = new ArrayList<Entity>();
                    cout << "new " << type << ", id= " << id;
                }

                void driver(EntityDriver *ed) {
                    driver = ed;
                }

                void step() {
                    driver->drive(this);
                    aliveTime += cycleTime;
                }

                void cycleTime(double t) const {
                    cycleTime = t;
                }

                double getCycleTime() const {
                    return cycleTime;
                }

                double getAliveTime() const {
                    return aliveTime;
                }

                // -- ACCESSORS --
                void add(const Entity& e) {
                    e.parent = this;
                    e.cycleTime = e.cycleTime!=0.0?e.cycleTime:cycleTime;		
                    ensemble.add( &e );
                }

                void add(const Property& p) {
                    properties.add( &p );
                }

                void add(const Constraint& c) {
                    constraints.add( &c );
                }

                vector<Entity *> *getEnsemble() const {
                    return ensemble;
                }

                vector<Property *> *getProperties() const {
                    return properties;
                }

                vector<Constraint *> *getConstraints() const {
                    return constraints;
                }

                vector<Entity *> *getEnsemble(const string& t) const {
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

                vector<IAffectable *> *getProperties(const string& t) const {
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

                vector<IAffectable *> *getConstraints(const string& t) {
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

        };
    }
}
#endif

