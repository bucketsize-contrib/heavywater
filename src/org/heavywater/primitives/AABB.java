package org.heavywater.primitives;

import java.util.List;

import org.heavywater.core.IConfinement;
import org.heavywater.core.IPrimitive;
import org.heavywater.core.IShape;

public class AABB implements IPrimitive, IConfinement {

	private Vector3[] bounds;
	
	public AABB(){
		bounds = new Vector3[2];
	}
	
	public AABB(IShape s){
		this();
		create(s);
	}
	
	public AABB(Vector3 a, Vector3 b) {
		this();
		create(a, b);
	}
	

	@Override
	public void create(IShape s) {
		List<Vector3> vs = s.getVertices();
		double xmin, xmax, ymin, ymax, zmin, zmax;
		xmin = xmax = ymin = ymax = zmin = zmax = 0.0f;
		for(Vector3 v: vs){
			xmin = xmin < v.X()? xmin: v.X();
			ymin = ymin < v.Y()? ymin: v.Y();
			zmin = zmin < v.Z()? zmin: v.Z();
			
			xmax = xmax > v.X()? xmax: v.X();
			ymax = ymax > v.Y()? ymax: v.Y();
			zmax = zmax > v.Z()? zmax: v.Z();
		}
		
		create(
				new Vector3(xmin, ymin, zmin), 
				new Vector3(xmax, ymax, zmax));
	}
	
	public void create(Vector3 a, Vector3 b) {
		bounds[0] = a; 
		bounds[1] = b;
	}

	
	Vector3 [] getBounds(){
		return bounds;
	}
	
	@Override
	public String toString() {
		return "(AABB "+bounds[0]+" "+bounds[1]+")";
	}

	@Override
	public boolean collidesWith(IConfinement c) {
		AABB[] cc = prepare((AABB)c);
		AABB a, b;
		
		a = cc[0]; b = cc[1];
		if (a.bounds[1].X() >= b.bounds[0].X()){
			a = cc[2]; b=cc[3];
			if (a.bounds[1].Y() >= b.bounds[0].Y()){
				a = cc[4]; b=cc[5];
				if (a.bounds[1].Z() >= b.bounds[0].Z()){
					return true;
				}
			}
		}
		
		return false;
	}
	@Override
	public boolean contains(IConfinement c) {
		if (collidesWith(c)){
			AABB[] cc = prepare((AABB)c);
			AABB a = cc[0]; AABB b = cc[1];
			if (a.bounds[1].X() > b.bounds[1].X() &&
					a.bounds[1].Y() > b.bounds[1].Y() &&
					a.bounds[1].Z() > b.bounds[1].Z()){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}


	// makes the closest AABB come first
	private AABB[] prepare(AABB aabb) {
		AABB ax, bx, ay, by, az, bz;
		if (bounds[0].X() > aabb.bounds[0].X()){
			ax = aabb; 
			bx = this;
		}else{
			ax = this; 
			bx = aabb;
		}
		
		if (bounds[0].Y() > aabb.bounds[0].Y()){
			ay = aabb; 
			by = this;
		}else{
			ay = this; 
			by = aabb;
		}
		
		if (bounds[0].Z() > aabb.bounds[0].Z()){
			az = aabb; 
			bz = this;
		}else{
			az = this; 
			bz = aabb;
		}
		
		return new AABB[] {ax, bx, ay, by, ax, bz};
	}

}
