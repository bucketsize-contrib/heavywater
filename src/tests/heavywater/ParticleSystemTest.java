package tests;

import junit.framework.TestCase;

import org.heavywater.driver.EngineDriver;
import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.property.Dynamics;
import org.heavywater.property.Kinetics;
import org.heavywater.ptypes.Vector3;

public class ParticleSystemTest extends TestCase {
	
	private int NUM_PAR = 10;

	public final void testRun(){
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.3);

		StateLogger logger = new StateLogger();
		logger.cycleTime(10.0);

		engine.add(logger);		
		
		ParticleSystem ps = new ParticleSystem();
		for(int i=0; i<NUM_PAR; ++i){
			Kinetics k = new Kinetics();
			Dynamics d = new Dynamics();
			d.accel = new Vector3(10.0, 0.0, 0.0);
			
			Particle p = new Particle();
			p.add(k);
			p.add(d);
			
			logger.add(p);
			
			ps.add(p);
		}
		
		engine.add(ps);
		
		engine.start();
	}
}