package tests;

import junit.framework.TestCase;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.StateLogger;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;

public class ParticleTest extends TestCase {
	
	public final void testCreateOne(){
		Engine engine = new Engine();
		engine.cycleTime(0.03);
		
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		
		Particle p = new Particle();
		p.add(d);
		
		StateLogger logger = new StateLogger();
		logger.cycleTime(0.3);
		logger.add(p);
		
		
		engine.add(p);
		engine.add(logger);
		
		engine.start();
	}
}
