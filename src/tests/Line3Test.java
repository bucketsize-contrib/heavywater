package tests;

import junit.framework.TestCase;

import org.heavywater.geom.Line3;
import org.heavywater.geom.Vector3;

public class Line3Test extends TestCase {

	public Line3Test(String name) {
		super(name);
		
	}

	public final void testLine3() {
		System.out.println("testLine3");
		try {
			Line3 l = new Line3();
			System.out.println(l.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testLine3DoubleDoubleDoubleDoubleDoubleDouble() {
		System.out.println("testLine3DoubleDoubleDoubleDoubleDoubleDouble");
		try {
			Line3 l = new Line3(0, 0, 0, 0, 10, 0);
			System.out.println(l.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testLine3Vector3Vector3() {
		System.out.println("testLine3Vector3Vector3");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testSetLine() {
		System.out.println("testSetLine");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.notation());

			l.setLine(-1, -1, -1, 0, 1, 0);
			System.out.println(l.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testGetVertices() {
		System.out.println("testGetVertices");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.getVertices());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testSetVertices() {
		System.out.println("testSetVertices");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.notation());

			l.setVertices(new Vector3(9, 4, 5), new Vector3(1, 2, 1));
			System.out.println(l.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testNotation() {
		System.out.println("testNotation");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testSetProcessor() {
		System.out.println("testSetProcessor");
		try {
			//Line3.setProcessor(new Line3Proc());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testLength() {
		System.out.println("testLength");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.length());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testLenghSQ() {
		System.out.println("testLenghSQ");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.lengthSQ());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testAxisVector() {
		System.out.println("testAxisVector");
		try {
			Line3 l = new Line3(new Vector3(0, 0, 0), new Vector3(0, 10, 0));
			System.out.println(l.axisVector().notation());
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testIntercept() {
		System.out.println("testIntercept");
		try {
			Line3 l1 = new Line3(new Vector3(20, 0, 0), new Vector3(20, 3, 0));
			System.out.println(l1.notation());
			
			Line3 l2 = new Line3(new Vector3(30, 17, 0), new Vector3(39, 17, 0));
			System.out.println(l2.notation());
			
			Vector3 v = l1.intercept(l2);
			System.out.println(v.notation());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

	public final void testInterceptAngle() {
		System.out.println("testInterceptAngle");
		try {
			
			Line3 l1 = new Line3(new Vector3(20, 0, 0), new Vector3(20, 3, 0));
			System.out.println(l1.notation());
			
			Line3 l2 = new Line3(new Vector3(30, 17, 0), new Vector3(39, 17, 0));
			System.out.println(l2.notation());
			
			System.out.println(l1.interceptAngle(l2)*180 / Math.PI);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage() + e.toString()); 
		}
	}

}
