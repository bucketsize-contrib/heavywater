package tests;

import junit.framework.TestCase;

import org.heavywater.geom.Quaternion;
import org.heavywater.geom.Vector3;

public class QuaternionTest extends TestCase {

	public QuaternionTest(String name) {
		super(name);
	}

	public final void testQuaternion() {
		System.out.println("testQuaternion");
		try {
			Quaternion q = new Quaternion();
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testQuaternionDoubleDoubleDoubleDouble() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(1,2,3,4);
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testQuaternionDoubleArray() {
		System.out.println("testQuaternionDoubleArray");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}

	}

	public final void testSetVector3() {
		System.out.println("testSetVector3");
		try {
			Quaternion q = new Quaternion();
			q.setVector(new Vector3(1,4.1,2));
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testGetVector3() {
		System.out.println("testGetVector3");
		try {
			Quaternion q = new Quaternion(new double [] {1,2.2,3,4.1});
			System.out.println(q.vector().notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testGetAsArray() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testSetAsArray() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testGetX() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetY() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetZ() {
		fail("Not yet implemented"); // TODO
	}

	public final void testGetW() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetX() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetY() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetZ() {
		fail("Not yet implemented"); // TODO
	}

	public final void testSetW() {
		fail("Not yet implemented"); // TODO
	}

	public final void testAdd() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testSub() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testMultDouble() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testMultQuaternion() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testNormalise() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testConjugate() {
		System.out.println("testQuaternionDoubleDoubleDoubleDouble");
		try {
			Quaternion q = new Quaternion(new double [] {1,2,3,4.1});
			System.out.println(q.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

}
