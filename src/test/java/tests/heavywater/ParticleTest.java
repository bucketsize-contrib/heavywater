package tests.heavywater;

import junit.framework.TestCase;

import org.heavywater.constraint.Thrust;
import org.heavywater.engine.Engine;
import org.heavywater.engine.EngineDriver;
import org.heavywater.entity.Particle;
import org.heavywater.entity.StateLogger;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Inertial;
import org.heavywater.property.Kinetics;

public class ParticleTest extends TestCase {
	
	public final void testCreateOne(){
		Kinetics k = new Kinetics();
		Dynamics d = new Dynamics();
		Inertial i = new Inertial();
		Thrust t = new Thrust();
		
		d.setfAccel(new Vector3(0.0, 0.0, -9.8));
		i.setMass(10.0);
		t.setForce(new Vector3(1.0, 0, 0));
		
		Particle p = new Particle();
		p.add(k);
		p.add(d);
		p.add(i);
		p.add(t);
		
		StateLogger logger = new StateLogger();
		logger.cycleTime(1);
		logger.add(p);
		
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		engine.add(p);
		engine.add(logger);
		
		engine.start(5.0);
		
		
	}
}
