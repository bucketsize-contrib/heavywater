package org.heavywater.affector;

import org.heavywater.core.Entity;
import org.heavywater.core.IPropertyResolver;
import org.heavywater.property.Dynamics;
import org.heavywater.property.ElectoStatic;
import org.heavywater.property.Geometry;
import org.heavywater.property.Inertial;
import org.heavywater.property.Kinetics;
import org.heavywater.util.InstanceFactory;

public class PropertyAffectorResolver implements IPropertyResolver {
	final String PREFIX = "org.heavywater.affector.";
	final String POSTFIX = "Affector";
	Entity e;
	
	public PropertyAffectorResolver(Entity e) {
		this.e = e;
	}

	@Override
	public Object resolve(Dynamics f) {
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

	@Override
	public Object resolve(Kinetics f) {
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

	@Override
	public Object resolve(ElectoStatic f) {
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

	@Override
	public Object resolve(Geometry f) {
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

	@Override
	public Object resolve(Inertial f) {
		return InstanceFactory.getInstance(PREFIX + e.getType() + f.getType()+ POSTFIX);
	}

}
