#ifndef _Axis3
#define _Axis3

#include "IPrimitive.h"

namespace hw {
namespace primitives {

class Axis3: Line3 {
public:
	Axis3() {
		super.setVertices(new Vector3(0, 0, 0), new Vector3(0, 0, 1));
	}

	Axis3(Vector3 p, Vector3 d) {
		super.setVertices(p, p.add(d));
	}
};
}
#endif
