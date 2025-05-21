package com.utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtlity {
	
	private static Logger logger;
	
	public LoggerUtlity() {
	}
	
	
	public static Logger getLogger(Class<?>clazz) {
		if(logger==null) {
		logger = LogManager.getLogger(clazz);
		}
		return logger;
	}

}
