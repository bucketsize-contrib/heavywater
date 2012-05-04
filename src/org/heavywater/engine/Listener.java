package org.heavywater.engine;

/*
 * instead of each entity having the ability to detect collision it subscribes 
 * to a listener to tell it when an event on it happens, it also delegates its 
 * response to that event to an external resolver
 * 
 * 1. makes the behaviour for same event - pluggable
 * 2. keeps you from creating / modifying many types of entities.
 */
public class Listener {

}
