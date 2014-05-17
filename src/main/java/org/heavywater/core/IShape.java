package org.heavywater.core;

import java.util.List;

import org.heavywater.primitives.Triangle;
import org.heavywater.primitives.Vector3;

public interface IShape {
	List<Vector3> getVertices();
	List<Triangle> getTriangles();
}
