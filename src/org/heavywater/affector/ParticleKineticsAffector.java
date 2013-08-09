package org.heavywater.affector;

import static org.heavywater.util.LogUtil.logInfo;

import java.util.List;

import org.heavywater.core.Entity;
import org.heavywater.core.IAffectable;
import org.heavywater.core.IAffector;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;
import org.heavywater.util.InstanceFactory;


public class ParticleKineticsAffector implements IAffector{
	
	public ParticleKineticsAffector(){
		logInfo("new "+this);
	}
	
	// compute kinematics from other affectables
	// there can be one or more secondary, depends on the affector scheme
	// single: when all tertiaries coalesce to one one secondary
	// multiple: when there can be a secondary per tertiary
	public void affect(IAffectable p, Entity e) {
		Kinetics k = (Kinetics) p;

		ParticleDynamicsAffector pda = (ParticleDynamicsAffector) InstanceFactory.
				getInstance("org.heavywater.affector.ParticleDynamicsAffector");
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
	public IAffectable aggregate(List<IAffectable> plist){
		Kinetics tkin = new Kinetics();
		for(IAffectable p: plist){
			Kinetics k = (Kinetics) p;
			tkin.velocity = tkin.velocity.add( k.velocity );
			tkin.angular_velocity = tkin.angular_velocity.add( k.angular_velocity );
		}
		return (IAffectable) tkin;
	}
		
}
