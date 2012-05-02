package org.heavywater.world;

import java.util.List;

public class Entity {
	protected List<Entity> ensemble;
	protected List<Property> properties;	
	
	public void tick(EntityDriver driver){
		driver.drive(this);
	}
}
