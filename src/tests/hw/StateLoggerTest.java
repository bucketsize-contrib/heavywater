package tests.hw;

import jb.hw.engine.Engine;
import jb.hw.engine.EngineDriver;
import jb.hw.entity.StateLogger;
import junit.framework.TestCase;


public class StateLoggerTest extends TestCase {

	public final void testLogger(){
		StateLogger logger = new StateLogger();
		
		Engine engine = new Engine(new EngineDriver());
		engine.cycleTime(0.03);
		engine.add(logger);
		engine.start();
	}
}
