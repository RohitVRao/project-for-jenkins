package practicepackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetry {
	@Test(retryAnalyzer = com.LifeInsuranceManagementSystem.GenericUtilities.RetryImplementationClass.class)
	public void PracticeRetry()
	{
		System.out.println("rishab");
		System.out.println("yash");
		Assert.fail();
		System.out.println("puneeth");
		System.out.println("darshan");
	}

}
