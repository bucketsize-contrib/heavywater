package tests.hw;

import jb.hw.engine.Engine;
import jb.hw.engine.EngineDriver;
import jb.hw.entity.Particle;
import jb.hw.entity.StateLogger;
import jb.hw.primitives.Vector3;
import jb.hw.property.Dynamics;
import jb.hw.property.Kinetics;
import junit.framework.TestCase;


public class ParticleTest extends TestCase {
	
	public final void testCreateOne(){
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		
		Kinetics k = new Kinetics();
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		
		Particle p = new Particle();
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
