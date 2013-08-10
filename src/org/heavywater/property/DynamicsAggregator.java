package org.heavywater.property;

import java.util.List;

import org.heavywater.core.Base;
import org.heavywater.core.IAffectable;

public class DynamicsAggregator extends Base{
	Dynamics aggregate;
	public DynamicsAggregator(){
		aggregate = new Dynamics();
	}
	
	public IAffectable aggregate(List<IAffectable> as){
		
		reset();
		
		for(IAffectable ia: as){
			Dynamics id = (Dynamics) ia;
			aggregate.accel = aggregate.accel.add(id.accel);
			aggregate.a_accel = aggregate.a_accel.add(id.a_accel);
		}
		return aggregate;
	}

	private void reset() {
		aggregate.copy(Dynamics.initial);
		
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}
}
