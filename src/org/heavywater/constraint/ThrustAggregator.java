package org.heavywater.constraint;

import java.util.List;

import org.heavywater.core.Base;
import org.heavywater.core.IAffectable;
import org.heavywater.primitives.Vector3;

public class ThrustAggregator extends Base {

	private Thrust aggregate;

	public ThrustAggregator(){
		aggregate = new Thrust();
	}

	private void reset() {
		aggregate.copy(Thrust.initial);
	}

	public IAffectable aggregate(List<IAffectable> as){

		reset();

		for(IAffectable thrust: as){
			Vector3 force = ((Thrust)thrust).force;
			aggregate.force = aggregate.force.add(force);
		}

		return aggregate;
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}

}
