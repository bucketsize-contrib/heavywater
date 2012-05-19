package org.heavywater.util;

public class LogUtil {
	private final static Logger logger = new Logger();
	
	public static void logInfo(String info){
		logger.logInfo(info);
	}
}
