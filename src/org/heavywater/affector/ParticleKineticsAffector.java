package org.heavywater.affector;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.List;

import org.heavywater.entity.Entity;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;
import org.heavywater.property.Property;
import org.heavywater.ptypes.Vector3;

// compute kinematics from secondary
// there can be one or more secondary, depends on the affector scheme
// single: when all tertiaries coalesce to one one secondary
// multiple: when there can be a secondary per tertiary
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
	
	public void affect(Property p, Entity e) {
		Kinetics k = (Kinetics) p;

		ParticleDynamicsAffector pda = (ParticleDynamicsAffector) ParticleDynamicsAffector.instance();
		Dynamics d = pda.aggregate( e.getProperties("Dynamics") ); 
		
		Vector3 a = d.accel;
		Vector3 v = k.velocity; 
		double t = e.getCycleTime();

		// s = s + ( v*t + 0.5*a*t^2 )
		k.location = k.location.add( v.mult(t).add(a.mult(t*t).mult(0.5)) );  

		// v = v + at
		k.velocity = v.add( a.mult(t) );
	}
	
	public Kinetics aggregate(List<Property> plist){
		Kinetics tkin = new Kinetics();
		for(Property p: plist){
			Kinetics k = (Kinetics) p;
			tkin.velocity = tkin.velocity.add( k.velocity );
			tkin.angular_velocity = tkin.angular_velocity.add( k.angular_velocity );
		}
		return tkin;
	}

}
