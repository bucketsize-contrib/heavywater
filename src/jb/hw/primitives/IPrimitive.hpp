#ifndef _IPrimitive
#define _IPrimitive

#include <string>
using namespace std;

namespace hw {
namespace primitives {

class IPrimitive {
public:
	virtual string notation()=0;
};
}
}
#endif
