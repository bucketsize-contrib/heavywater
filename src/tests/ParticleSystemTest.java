package tests;

import junit.framework.TestCase;

import org.heavywater.entity.Engine;
import org.heavywater.entity.Particle;
import org.heavywater.entity.ParticleSystem;
import org.heavywater.primitives.Vector3;
import org.heavywater.property.Dynamics;

public class ParticleSystemTest extends TestCase {

	public final void testCreation(){
		ParticleSystem ps = new ParticleSystem();
	}
	
	public final void testRun(){
		Dynamics d = new Dynamics();
		d.accel = new Vector3(10.0, 0.0, 0.0);
		
		Particle p = new Particle();
		p.add(d);
		
		ParticleSystem ps = new ParticleSystem();
		for(int i=0; i<10; ++i){
			ps.add(p);
		}
		
		Engine engine = new Engine();
		engine.cycleTime(0.03);
		engine.add(ps);
		engine.start();
	}
}
