package tests;

import junit.framework.TestCase;

import org.heavywater.driver.EngineDriver;
import org.heavywater.entity.Engine;
import org.heavywater.entity.StateLogger;

public class StateLoggerTest extends TestCase {

	public final void testLogger(){
		StateLogger logger = new StateLogger();
		
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		engine.add(logger);
		engine.start();
	}
}
