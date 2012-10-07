package org.heavywater.affector;

import java.util.List;

import org.heavywater.core.IAffectable;
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

	public void affect(IAffectable p, Entity e) {
		
	}
	
	public IAffectable aggregate(List<IAffectable> dlist){
		//System.out.println("aggregating:");
		Dynamics tdyn = new Dynamics();
		for(IAffectable p: dlist){
			Dynamics d = (Dynamics)p;
			//System.out.println("..."+d.inspect());
			tdyn.accel = tdyn.accel.add( d.accel );
			tdyn.a_accel = tdyn.a_accel.add( d.a_accel );
		}
		//System.out.println("= " + tdyn.inspect());
		return (IAffectable) tdyn;
	}

}
