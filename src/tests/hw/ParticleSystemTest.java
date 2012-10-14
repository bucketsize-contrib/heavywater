package tests.hw;

import jb.hw.engine.Engine;
import jb.hw.engine.EngineDriver;
import jb.hw.entity.Particle;
import jb.hw.entity.ParticleSystem;
import jb.hw.entity.StateLogger;
import jb.hw.primitives.Vector3;
import jb.hw.property.Dynamics;
import jb.hw.property.Kinetics;
import junit.framework.TestCase;


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
