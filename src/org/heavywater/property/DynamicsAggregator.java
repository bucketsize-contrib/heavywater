package org.heavywater.property;

import java.util.List;

import org.heavywater.core.Base;
import org.heavywater.core.IAffectable;

public class DynamicsAggregator extends Base{
	
	private Dynamics aggregate;
	
	public DynamicsAggregator(){
		aggregate = new Dynamics();
	}
	
	private void reset() {
		aggregate.copy(Dynamics.initial);
	}
	
	public IAffectable aggregate(List<IAffectable> as){
		
		reset();
		
		for(IAffectable ia: as){
			Dynamics id = (Dynamics) ia;
			aggregate.l_accel = aggregate.l_accel.add(id.l_accel);
			aggregate.w_accel = aggregate.w_accel.add(id.w_accel);
			aggregate.f_accel = aggregate.f_accel.add(id.f_accel);
		}
		return aggregate;
	}

	@Override
	public String inspect() {
		// TODO Auto-generated method stub
		return null;
	}
}
