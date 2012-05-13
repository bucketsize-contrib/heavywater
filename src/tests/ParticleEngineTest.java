package tests;

import junit.framework.TestCase;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;

public class ParticleEngineTest extends TestCase {
	
	public final void testCreateOne(){
		Engine pEngine = new Engine();
		
		Particle p = new Particle();
		
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		d.g_accel = new Vector3(0.0, -9.8, 0.0);
		
		p.add(d);
		
		pEngine.add(p);
		pEngine.start();
	}
}
