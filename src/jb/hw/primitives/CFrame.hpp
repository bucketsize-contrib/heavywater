#ifndef _CFrame
#define _CFrame

#include "IPrimitive.h"

namespace hw {
namespace primitives {

class CFrame: IPrimitive {

private:
	Vector3 ux;
	Vector3 uy;
	Vector3 uz;
	Vector3 pos;
	//
	Matrix4 transform;

public:
	CFrame() {
		// default matrix init
	}

	Vector3 X() {
		return ux;
	}

	void setX(Vector3 ux) {
		this->ux.copy(ux);
	}

	Vector3 Y() {
		return uy;
	}

	void setY(Vector3 uy) {
		this->uy.copy(uy);
	}

	Vector3 Z() {
		return uz;
	}

	void setZ(Vector3 uz) {
		this->uz.copy(uz);
	}

	Vector3 pos() {
		return pos;
	}

	void setPos(Vector3 pos) {
		this->pos = new Vector3(pos);
	}

	Matrix4 transform() {
		return transform;
	}

	void setTransform(Matrix4 transform) {
		this->transform.equal(transform);
	}

	string notation() {
		// TODO Auto-generated method stub
		return null;
	}

};
}
}
#endif
