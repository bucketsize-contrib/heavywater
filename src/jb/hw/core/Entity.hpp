#ifndef _hw_core_Entity
#define _hw_core_Entity

#include <iostream>
#include <string>
#include <vector>

#include "Base.hpp"
#include "EntityDriver.hpp"
#include "IVisitable.hpp"
#include "IAffectable.hpp"
#include "Property.hpp"
#include "Constraint.hpp"

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
                Entity();

                Entity(EntityDriver *);


                void step();



                // -- ACCESSORS --
                void setAliveTime(double) const;

                double getAliveTime() const;

                void setCycleTime(double ) const;

                double getCycleTime() const;

                void setDriver(EntityDriver *);

                EntityDriver *getDriver();

                void add(const Entity&);

                void add(const Property &);

                void add(const Constraint &);

                vector<Entity *> *getEnsemble() const;

                vector<Property *> *getProperties() const;

                vector<Constraint *> *getConstraints() const;

                vector<Entity *> *getEnsemble(const string &) const;

                vector<IAffectable *> *getProperties(const string &) const;

                vector<IAffectable *> *getConstraints(const string &);

        };
    }
}
#endif

