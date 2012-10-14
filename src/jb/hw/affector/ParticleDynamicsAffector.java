package jb.hw.affector;

import java.util.List;

import jb.hw.core.Entity;
import jb.hw.core.IAffectable;
import jb.hw.core.IAffector;
import jb.hw.property.Dynamics;


// aggregate the dynamics from tertiary entity properties 
// to secondary
public class ParticleDynamicsAffector implements IAffector{
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
