package tests;

import junit.framework.TestCase;

import org.heavywater.driver.EngineDriver;
import org.heavywater.driver.ParticleDriver;
import org.heavywater.driver.ParticleSystemDriver;
import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;

public class ParticleSystemTest extends TestCase {
	
	private int NUM_PAR = 10;

	public final void testRun(){
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.01);

		StateLogger logger = new StateLogger();
		logger.cycleTime(20.0);

		engine.add(logger);		
		
		ParticleSystem ps = new ParticleSystem(new ParticleSystemDriver());
		for(int i=0; i<NUM_PAR; ++i){
			Kinetics k = new Kinetics();
			Dynamics d = new Dynamics();
			d.accel = new Vector3(10.0, 0.0, 0.0);
			
			Particle p = new Particle(new ParticleDriver());
			p.add(k);
			p.add(d);
			
			logger.add(p);
			
			ps.add(p);
		}
		
		engine.add(ps);
		
		engine.start();
	}
}
