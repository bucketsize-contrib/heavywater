package org.heavywater.util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class Logger {

	private final static java.util.logging.Logger LOGGER = java.util.logging.Logger
			.getLogger(Logger.class.getName());

	public Logger(){
		LOGGER.setLevel(Level.INFO);
		FileHandler fh=null;
		try {
			fh = new FileHandler("log/heavy.log");
		} catch (SecurityException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
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
		//LOGGER.info(info);
		System.out.println(info);
	}
}
