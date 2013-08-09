package org.heavywater.affector;

import java.util.List;

import org.heavywater.core.Entity;
import org.heavywater.core.IAffectable;
import org.heavywater.core.IAffector;
import org.heavywater.property.Dynamics;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector implements IAffector{

	public void affect(IAffectable p, Entity e) {
	}
	
	public IAffectable aggregate(List<IAffectable> dlist){
		Dynamics tdyn = new Dynamics();
		for(IAffectable p: dlist){
			Dynamics d = (Dynamics)p;
			tdyn.accel = tdyn.accel.add( d.accel );
			tdyn.a_accel = tdyn.a_accel.add( d.a_accel );
		}
		return (IAffectable) tdyn;
	}

}
