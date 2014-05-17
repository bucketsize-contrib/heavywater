package tests.heavywater;

import junit.framework.TestCase;

import org.heavywater.primitives.AABB;
import org.heavywater.primitives.Vector3;

public class AABBTest extends TestCase {

  AABB[] ccN = {
    new AABB( //0
        new Vector3(10, 0, 0),
        new Vector3(15, 5, 0)
        ),

    new AABB( //1
        new Vector3(20, 0, 0),
        new Vector3(24, 4, 0)
        ),

    new AABB( //2
        new Vector3(5, 5, 5),
        new Vector3(10, 10, 10)
        ),

    new AABB( //3
        new Vector3(12, 12, 12),
        new Vector3(15, 15, 15)
        )

  };

  AABB[] cc = {
    new AABB( //0
        new Vector3(10, 0, 0), 
        new Vector3(15, 5, 0)
        ),

    new AABB( //1
        new Vector3(13, 0, 0),	
        new Vector3(17, 4, 0)
        ),

    new AABB( //2
        new Vector3(0, 10, 0),
        new Vector3(5, 15, 0)
        ),

    new AABB( //3
        new Vector3(0, 9, 0),
        new Vector3(4, 13, 0)
        ),

    new AABB( //4
        new Vector3(0, 10, 0),
        new Vector3(5, 15, 0)
        ),

    new AABB( //5
        new Vector3(0, 9, 0),
        new Vector3(4, 13, 0)
        ),

    new AABB( //6
        new Vector3(5, 5, 5),
        new Vector3(10, 10, 10)
        ),

    new AABB( //7
        new Vector3(7, 7, 7),
        new Vector3(11, 11, 11)
        )
  };

  public void setup(){

  }

  public AABBTest(String name) {
    super(name);

  }

  public final void testNoCollision() {
    System.out.println("testNoCollision");
    printResult(ccN[0], ccN[1]);
    printResult(ccN[2], ccN[3]);

  }


  public final void testCollision() {
    System.out.println("testCollision");
    printResult(cc[0], cc[1]);
    printResult(cc[2], cc[3]);
    printResult(cc[4], cc[5]);
    printResult(cc[6], cc[7]);

  }

  private void printResult(AABB aabb, AABB aabb2) {
    System.out.printf("\n%s, \n%s, \n%s\n", aabb, aabb2, aabb.collidesWith(aabb2));
  }


}
