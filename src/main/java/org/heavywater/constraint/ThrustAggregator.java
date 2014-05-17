package org.heavywater.constraint;

import java.util.List;

import org.heavywater.core.Base;
import org.heavywater.core.IAffectable;
import org.heavywater.primitives.Vector3;

public class ThrustAggregator extends Base {

	public IAffectable aggregate(List<IAffectable> as){
		Thrust aggregate = new Thrust();
		for(IAffectable thrust: as){
			Vector3 force = ((Thrust)thrust).getForce();
			aggregate.setForce(aggregate.getForce().add(force));
		}

		return aggregate;
	}

}
