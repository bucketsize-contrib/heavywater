package jb.hw.util;

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
		FileHandler fh=null;
		try {
			fh = new FileHandler("heavy.log");
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		LogFormatter sf = new LogFormatter(); 
		fh.setFormatter(sf);
		
		try {
			LOGGER.addHandler(fh);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void logInfo(String info){
		LOGGER.info(info);
	}
}
