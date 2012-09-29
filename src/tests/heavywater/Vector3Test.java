package tests.heavywater;

import junit.framework.TestCase;

import org.heavywater.ptypes.Vector3;

public class Vector3Test extends TestCase {

	public Vector3Test(String name) {
		super(name);

	}

	public final void testVector3() {
		System.out.println("testVector3");
		try {
			Vector3 v = new Vector3();
			System.out.println(v.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testVector3DoubleDoubleDouble() {
		System.out.println("testVector3DoubleDoubleDouble");
		try {
			Vector3 v = new Vector3(1, 2, 3);
			System.out.println(v.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testVector3Vector3() {
		System.out.println("testVector3Vector3");
		try {
			Vector3 v = new Vector3(new Vector3(51, 5, 34));
			System.out.println(v.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testEqual() {
	}

	public final void testGetX() {
	}

	public final void testSetX() {
	}

	public final void testGetY() {
	}

	public final void testSetY() {
	}

	public final void testGetZ() {
	}

	public final void testSetZ() {
	}

	public final void testGetAsArray() {
		System.out.println("testGetAsArray");
		try {
			Vector3 v = new Vector3(1, 5, 3);
			System.out.println(v.array().length);
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testIsZero() {
		System.out.println("testIsZero");
		try {
			Vector3 v = new Vector3();
			System.out.println(v.isZero());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testIsEqual() {
		System.out.println("testIsEqual");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(1, 1, -1);
			Vector3 v3 = new Vector3(10, 10, 10);
			System.out.println(v1.isEqual(v2));
			System.out.println(v1.isEqual(v3));
			System.out.println(v1.isEqual(new Vector3(1, 1, 1)));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testIsParallel() {
		System.out.println("testIsParallel");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(-1, -1, -1);
			Vector3 v3 = new Vector3(10, 10, 10);
			System.out.println(v1.isParallel(v2));
			System.out.println(v1.isParallel(v3));
			System.out.println(v1.isParallel(new Vector3(1, 21, 2)));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testSetProcessor() {
	}

	public final void testNotation() {
	}

	public final void testAdd() {
		System.out.println("testAdd");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(-1, -1, 1);

			System.out.println(v1.add(v2).notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testSub() {
		System.out.println("testSub");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(-1, -1, 1);

			System.out.println(v1.sub(v2).notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testMult() {
		System.out.println("testMult");
		try {
			Vector3 v1 = new Vector3(1, 1, -1);

			System.out.println(v1.mult(2.5).notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testLength() {
		System.out.println("testLength");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);

			System.out.println(v1.length());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testLengthSQ() {
		System.out.println("testLengthSQ");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);

			System.out.println(v1.lengthSQ());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testDot() {
		System.out.println("testDot");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(-1, 1, -1);

			System.out.println(v1.dot(v2));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testCross() {
		System.out.println("testCross");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(1, -1, -1);

			System.out.println(v1.cross(v2).notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testIsBetweenPoints() {
		fail("not yet implemented");
	}

	public final void testNormalize() {
		System.out.println("testNormalize");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);

			System.out.println(v1.normalize().notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testAngle() {
		System.out.println("testAngle");
		try {
			Vector3 v1 = new Vector3(1, 1, 1);
			Vector3 v2 = new Vector3(1, 1, -1);

			System.out.println(v1.angle(v2));
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

}
