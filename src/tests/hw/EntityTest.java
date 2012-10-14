package tests.hw;

import jb.hw.entity.Particle;

import junit.framework.TestCase;

public class EntityTest extends TestCase {
	public static void testEntity(){
		Particle p = new Particle();
		System.out.printf("Particle: %s, %s", p.getType(), p.inspect());
	}
}
