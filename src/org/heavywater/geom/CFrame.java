package org.heavywater.geom;

import org.heavywater.geom.Geom;
import org.heavywater.geom.Matrix4;
import org.heavywater.geom.Vector3;

public class CFrame extends Geom {

	private Vector3 ux;
	private Vector3 uy;
	private Vector3 uz;
	private Vector3 pos;
	//
	private Matrix4 transform;

	public CFrame() {
		// default matrix init
	}

	public Vector3 getUx() {
		return ux;
	}

	public void setUx(Vector3 ux) {
		this.ux.equal(ux);
	}

	public Vector3 getUy() {
		return uy;
	}

	public void setUy(Vector3 uy) {
		this.uy.equal(uy);
	}

	public Vector3 getUz() {
		return uz;
	}

	public void setUz(Vector3 uz) {
		this.uz.equal(uz);
	}

	public Vector3 getPos() {
		return pos;
	}

	public void setPos(Vector3 pos) {
		this.pos = new Vector3(pos);
	}

	public Matrix4 getTransform() {
		return transform;
	}

	public void setTransform(Matrix4 transform) {
		this.transform.equal(transform);
	}

	@Override
	public String notation() {
		// TODO Auto-generated method stub
		return null;
	}

}
