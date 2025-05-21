package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.constants.Env.*;

public class MyRetryAnalyer implements IRetryAnalyzer{
	
	private static final int NUMBER_OF_ATTEMPTS = Integer.parseInt(com.utility.PropertiesUtil.getProperty(QA, "NUMBER_OF_ATTEMPTS"));
	private static  int current_attempt= 1;

	@Override
	public boolean retry(ITestResult result) {
		if(current_attempt<NUMBER_OF_ATTEMPTS) {
			current_attempt++;
			return true;
		}
		
		return false;
	}

}
