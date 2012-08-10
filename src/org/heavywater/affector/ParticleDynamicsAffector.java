package org.heavywater.affector;

import java.util.List;

import org.heavywater.entity.Entity;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector extends Affector{
	// singleton
	private static Object ins;	
	public static Object instance(){
		return ins!=null?ins:(ins=new ParticleDynamicsAffector());
	}
	// !singleton

	@Override
	public void affect(Property p, Entity e) {
		
	}
	
	public Dynamics aggregate(List<Property> dlist){
		Dynamics tdyn = new Dynamics();
		for(Property p: dlist){
			Dynamics d = (Dynamics)p;
			tdyn.accel = tdyn.accel.add( d.accel );
			tdyn.a_accel = tdyn.a_accel.add( d.a_accel );
		}
		return tdyn;
	}

}
