package org.heavywater.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Logger {
	// singleton
	private static Object ins;

	public static Object instance() {
		return ins != null ? ins : (ins = create());
	}

	private static Object create() {
		return new Logger();
	}
	// !singleton

	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(Logger.class.getName());

	public Logger(){
		LOGGER.setLevel(Level.INFO);
		try {
			LOGGER.addHandler(new FileHandler("Logging.txt"));
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void logInfo(String info){
		LOGGER.info(info);
	}
}
