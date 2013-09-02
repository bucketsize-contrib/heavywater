package org.heavywater.property;

import org.heavywater.core.IAffectorResolver;
import org.heavywater.core.IResolver;
import org.heavywater.core.Property;
import org.heavywater.primitives.Vector3;

// primary; this will yield due to changes in secondarie(s)
// ie - dynamics
// NOTE: when the context changes to chemical reactions / biochemical inteactions
// primary and secondary will change to more apt parameters
// like reaction energies, geospatial scores
// how ever former primaries can figure as tertiary properties, depending on the
// affector scheme
public class Kinetics extends Property {
	// primary properties; not modifiable by external
	private Vector3 loc;
	private double wLoc; // radians
	private Vector3 vel;
	private Vector3 wVel;

	public Vector3 getLoc() {
		return loc;
	}

	public void setLoc(Vector3 loc) {
		this.loc = loc;
	}

	public double getwLoc() {
		return wLoc;
	}

	public void setwLoc(double wLoc) {
		this.wLoc = wLoc;
	}

	public Vector3 getVel() {
		return vel;
	}

	public void setVel(Vector3 vel) {
		this.vel = vel;
	}

	public Vector3 getwVel() {
		return wVel;
	}

	public void setwVel(Vector3 wVel) {
		this.wVel = wVel;
	}

	public Kinetics(){
		loc = new Vector3();
		wLoc = 0.0;
		vel = new Vector3();
		wVel = new Vector3();
		
		type = "Kinetics";
	}

	
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("(Kinetics");
		sb.append(" p=");
		sb.append(loc.toString());
		sb.append(" v=");
		sb.append(vel.toString());
		sb.append(")");

		return sb.toString();
	}

	@Override
	public Object dispatch(IResolver r) {
		return ((IAffectorResolver) r).resolve(this);
	}

	@Override
	public void copy(Property p) {
		Kinetics k = (Kinetics) p;
		
		loc.setX(k.loc.X());
		loc.setY(k.loc.Y());
		loc.setZ(k.loc.Z());
		
		wLoc = k.wLoc;
		
		vel.setX(k.vel.X());
		vel.setY(k.vel.Y());
		vel.setZ(k.vel.Z());
		
		wVel.setX(k.wVel.X());
		wVel.setY(k.wVel.Y());
		wVel.setZ(k.wVel.Z());
		
	}
	
}
