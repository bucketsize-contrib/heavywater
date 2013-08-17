package tests.heavywater;

import junit.framework.TestCase;

import org.heavywater.engine.Engine;
import org.heavywater.engine.EngineDriver;

public class EngineTest extends TestCase {
	public static void testTimedEngine(){
		
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		
		engine.start(10);
	}
	
	public static void testEngine(){
		
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		
		engine.start();
	}

}
