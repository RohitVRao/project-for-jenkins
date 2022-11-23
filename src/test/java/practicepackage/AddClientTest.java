package practicepackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddClientTest {
	
	
	@Test(priority = -2, invocationCount = 1 )
	public void Addclient()
	{
		Reporter.log("client is added successfully", true);
		
	}
	
	@Test(priority = -1, invocationCount = -1, dependsOnMethods = "Deleteclient" )
	public void Updateclient()
	{
		Reporter.log("client details is updated successfully", true);
		
	}
	
	@Test(priority = 1, invocationCount = 1)
	public void Deleteclient()
	{
		Reporter.log("client is deleted successfully", true);
		
	}

}
