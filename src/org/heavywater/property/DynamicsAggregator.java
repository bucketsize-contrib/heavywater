package org.heavywater.property;

import java.util.List;

import org.heavywater.core.Base;
import org.heavywater.core.IAffectable;

public class DynamicsAggregator extends Base{
	
	public IAffectable aggregate(List<IAffectable> as){
		Dynamics aggregate = new Dynamics();
		for(IAffectable ia: as){
			Dynamics id = (Dynamics) ia;
			aggregate.setlAccel(aggregate.getlAccel().add(id.getlAccel()));
			aggregate.setwAccel(aggregate.getwAccel().add(id.getwAccel()));
			aggregate.setfAccel(aggregate.getfAccel().add(id.getfAccel()));
		}
		return aggregate;
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}
}
