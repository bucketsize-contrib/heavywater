package org.heavywater.affector;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.List;

import org.heavywater.core.Affectable;
import org.heavywater.core.Affector;
import org.heavywater.core.Constraint;
import org.heavywater.core.Entity;
import org.heavywater.core.Property;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;
import org.heavywater.ptypes.Vector3;


public class ParticleKineticsAffector extends Affector{
	//
	private static Object ins;	
	public static Object instance(){
		return ins!=null?ins:(ins=new ParticleKineticsAffector());
	}
	//
	public ParticleKineticsAffector(){
		logInfo("new "+this);
	}
	
	// compute kinematics from other affectables
	// there can be one or more secondary, depends on the affector scheme
	// single: when all tertiaries coalesce to one one secondary
	// multiple: when there can be a secondary per tertiary
	public void affect(Affectable p, Entity e) {
		Kinetics k = (Kinetics) p;

		ParticleDynamicsAffector pda = (ParticleDynamicsAffector) ParticleDynamicsAffector.instance();
		Dynamics d = (Dynamics) pda.aggregate( e.getProperties("Dynamics") ); 
		
		Vector3 a = d.accel;
		Vector3 v = k.velocity; 
		double t = e.getCycleTime();

		// s = s + ( v*t + 0.5*a*t^2 )
		k.location = k.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  

		// v = v + at
		k.velocity = v.add( a.mult(t) );
	}
	
	// aggregate related properties	
	public Affectable aggregate(List<Affectable> plist){
		Kinetics tkin = new Kinetics();
		for(Affectable p: plist){
			Kinetics k = (Kinetics) p;
			tkin.velocity = tkin.velocity.add( k.velocity );
			tkin.angular_velocity = tkin.angular_velocity.add( k.angular_velocity );
		}
		return tkin;
	}
		
}
