package org.heavywater.event;

public class EventFlag {

	private final Object flag = new Object();

	public void signal() {
		synchronized (flag) {
			flag.notify();
		}
	}

	public void await() throws InterruptedException {
		synchronized (flag) {
			flag.wait();
		}
	}


}
