package tests;

import junit.framework.TestCase;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;

public class ParticleEngineTest extends TestCase {
	
	public final void testCreateOne(){
		Engine pEngine = new Engine();
		pEngine.cycleTime(0.03);
		
		Particle p = new Particle();
		
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		
		p.add(d);
		
		pEngine.add(p);
		pEngine.start();
	}
}
