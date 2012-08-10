package org.heavywater.affector;

import java.util.List;

import org.heavywater.entity.Entity;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Property;
import org.heavywater.util.prNotation;

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
		System.out.println("aggregating ...");
		Dynamics tdyn = new Dynamics();
		for(Property p: dlist){
			Dynamics d = (Dynamics)p;
			System.out.println(d.inspect((prNotation) prNotation.instance()));
			tdyn.accel = tdyn.accel.add( d.accel );
			tdyn.a_accel = tdyn.a_accel.add( d.a_accel );
		}
		System.out.println("results: " + tdyn.inspect((prNotation) prNotation.instance()));
		return tdyn;
	}

}
