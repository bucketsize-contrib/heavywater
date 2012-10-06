package org.heavywater.affector;

import java.util.List;

import org.heavywater.core.Affectable;
import org.heavywater.core.Affector;
import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.Property;
import org.heavywater.property.Dynamics;

// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector extends Affector{
	// singleton
	private static Object ins;	
	public static Object instance(){
		return ins!=null?ins:(ins=new ParticleDynamicsAffector());
	}
	// !singleton

	public void affect(Affectable p, Entity e) {
		
	}
	
	public Affectable aggregate(List<Affectable> dlist){
		//System.out.println("aggregating:");
		Dynamics tdyn = new Dynamics();
		for(Affectable p: dlist){
			Dynamics d = (Dynamics)p;
			//System.out.println("..."+d.inspect());
			tdyn.accel = tdyn.accel.add( d.accel );
			tdyn.a_accel = tdyn.a_accel.add( d.a_accel );
		}
		//System.out.println("= " + tdyn.inspect());
		return tdyn;
	}

}
