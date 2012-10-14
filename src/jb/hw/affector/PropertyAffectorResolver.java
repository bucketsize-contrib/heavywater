package jb.hw.affector;

import jb.hw.core.Entity;
import jb.hw.core.IPropertyResolver;
import jb.hw.property.Dynamics;
import jb.hw.property.ElectoStatic;
import jb.hw.property.Geometry;
import jb.hw.property.Inertial;
import jb.hw.property.Kinetics;
import jb.hw.util.InstanceFactory;


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
