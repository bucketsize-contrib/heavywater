package tests;

import junit.framework.TestCase;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.entity.StateLogger;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Kinetics;

public class ParticleSystemTest extends TestCase {
	
	public final void testRun(){
		Engine engine = new Engine();
		engine.cycleTime(0.01);

		StateLogger logger = new StateLogger();
		logger.cycleTime(20.0);

		engine.add(logger);		
		
		ParticleSystem ps = new ParticleSystem();
		for(int i=0; i<5000; ++i){
			Kinetics d = new Kinetics();
			d.accel = new Vector3(10.0, 0.0, 0.0);
			
			Particle p = new Particle();
			p.add(d);
			
			logger.add(p);
			
			ps.add(p);
		}
		
		engine.add(ps);
		
		engine.start();
	}
}
