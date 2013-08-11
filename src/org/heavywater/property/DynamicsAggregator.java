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
			aggregate.l_accel = aggregate.l_accel.add(id.l_accel);
			aggregate.w_accel = aggregate.w_accel.add(id.w_accel);
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
