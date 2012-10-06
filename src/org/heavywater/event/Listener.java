package org.heavywater.event;

import java.util.List;

import org.heavywater.core.Entity;

/**
 * Listener polls for event on registered entities
 * 
 * instead of each entity having the ability to detect collision it subscribes 
 * to a listener to tell it when an event on it happens, it also delegates its 
 * response to that event to an external resolver
 * 
 * 1. makes the behaviour for same event - pluggable
 * 2. keeps you from creating / modifying many types of entities.
 */
public abstract class Listener {
	
	private long poll_inteval_milli;
	
	/**
	 * generate list of entities to be notified of an event
	 * @return
	 */
	private List<Entity> poll(){
		return null;
	}

	public void listen() {
		// TODO Auto-generated method stub
		
	}
}
