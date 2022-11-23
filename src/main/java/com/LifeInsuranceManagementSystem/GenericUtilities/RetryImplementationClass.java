package com.LifeInsuranceManagementSystem.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	
	int count = 0;
	int RetryLimit = 3;
	public boolean retry(ITestResult result)
	{
		if(count < RetryLimit)
		{
			count++;
			return true;
		}
		return false;
	}

}
