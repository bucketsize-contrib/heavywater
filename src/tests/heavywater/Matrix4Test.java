package tests.heavywater;

import junit.framework.TestCase;

import org.heavywater.primitives.Matrix4;

public class Matrix4Test extends TestCase {

	public Matrix4Test(String name) {
		super(name);
	}

	public final void testMatrix4() {
		System.out.println("testMatrix4");
		try {
			Matrix4 m = new Matrix4();
			System.out.println(m.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testMatrix4DoubleArrayArray() {
		System.out.println("testMatrix4DoubleArrayArray");
		try {
			Matrix4 m = new Matrix4(new double [][] {
					{1,2,3,4},
					{2,3,4,5},
					{3,4,5,6},
					{4,5,6,7}
			});
			System.out.println(m.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testSetAsArray() {
		System.out.println("testMatrix4DoubleArrayArray");
		try {
			Matrix4 m = new Matrix4();
			System.out.println(m.notation());
			double [][] a= {
					{1,2,3,4},
					{2,3,4,5},
					{3,4,5,6},
					{4,5,6,7}
			};
			m.setArray(a);
			System.out.println(m.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}	}

	

	public final void testGetAsArray() {
	}

	public final void testGetElementIntInt() {
	}

	public final void testEqual() {
	}

	public final void testSetProcessor() {
	}

	public final void testSetAsIdentity() {
	}

	public final void testMultDouble() {
		System.out.println("testMultDouble");
		try {
			Matrix4 m = new Matrix4(new double [][] {
					{1,2,3,4},
					{2,3,4,5},
					{3,4,5,6},
					{4,5,6,7}
			});
			System.out.println(m.mult(2).notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

	public final void testMultQuaternion() {
		fail("Not yet implemented"); // TODO test quaternios first
	}

	public final void testMultMatrix4() {
		System.out.println("testMultDouble");
		try {
			Matrix4 m = new Matrix4(new double [][] {
					{1,2,3,4},
					{2,3,4,5},
					{3,4,5,6},
					{4,5,6,7}
			});
			
			Matrix4 m2 = new Matrix4(new double [][] {
					{1,2,3,4},
					{2,3,4,5},
					{3,4,5,6},
					{4,5,6,7}
			});
			
			System.out.println(m.mult(m2).notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString());
		}
	}

}
