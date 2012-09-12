package org.heavywater.ptypes;


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

	public Vector3 X() {
		return ux;
	}

	public void setX(Vector3 ux) {
		this.ux.copy(ux);
	}

	public Vector3 Y() {
		return uy;
	}

	public void setY(Vector3 uy) {
		this.uy.copy(uy);
	}

	public Vector3 Z() {
		return uz;
	}

	public void setZ(Vector3 uz) {
		this.uz.copy(uz);
	}

	public Vector3 pos() {
		return pos;
	}

	public void setPos(Vector3 pos) {
		this.pos = new Vector3(pos);
	}

	public Matrix4 transform() {
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
