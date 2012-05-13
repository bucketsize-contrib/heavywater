package tests;

import junit.framework.TestCase;

import org.heavywater.entity.Particle;
import org.heavywater.event.Engine;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;

public class ParticleEngineTest extends TestCase {
	
	public final void testCreateOne(){
		Engine particleEngine = new Engine();
		
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		d.g_accel = new Vector3(0.0, -9.8, 0.0);
		
		particleEngine.add(new Particle());
		particleEngine.start();
	}
}
