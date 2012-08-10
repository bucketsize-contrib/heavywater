package tests;

import junit.framework.TestCase;

import org.heavywater.driver.EngineDriver;
import org.heavywater.driver.ParticleDriver;
import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.StateLogger;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;

public class ParticleTest extends TestCase {
	
	public final void testCreateOne(){
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		
		Kinetics k = new Kinetics();
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		
		Particle p = new Particle(new ParticleDriver());
		p.add(k);
		p.add(d);
		
		StateLogger logger = new StateLogger();
		logger.cycleTime(0.3);
		logger.add(p);
		
		
		engine.add(p);
		engine.add(logger);
		
		engine.start();
	}
}
