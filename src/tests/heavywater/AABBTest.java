package tests.heavywater;

import junit.framework.TestCase;

import org.heavywater.primitives.AABB;
import org.heavywater.primitives.Vector3;

public class AABBTest extends TestCase {

	public AABBTest(String name) {
		super(name);

	}

	public final void testNoCollision() {
		AABB aabb1 = new AABB(
				new Vector3(10, 0, 0),
				new Vector3(15, 5, 0)
				);
		
		AABB aabb2 = new AABB(
				new Vector3(20, 0, 0),
				new Vector3(24, 4, 0)
				);
		
		System.out.println(aabb1.collidesWith(aabb2));
		
	}

	public final void testCollision() {
		AABB aabb1 = new AABB(
				new Vector3(10, 0, 0),
				new Vector3(15, 5, 0)
				);
		
		AABB aabb2 = new AABB(
				new Vector3(13, 0, 0),
				new Vector3(17, 4, 0)
				);
		
		System.out.println(aabb1.collidesWith(aabb2));
		
	}

}
