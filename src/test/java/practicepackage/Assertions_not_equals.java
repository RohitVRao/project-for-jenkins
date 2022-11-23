package practicepackage;

import static org.testng.Assert.assertNull;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class Assertions_not_equals
{
	@Test
	
	public void cricket()
	{
	String x = "India";
	String y = "Australia";
	System.out.println("Rohit Sharma");
	assertTrue(x.equals(y));
	System.out.println("Aaron Finch");
	}
	
	
	@Test
	
	public void worldcup()
	{
		String a = null;
		assertNull(a);
		System.out.println("K L Rahul");
	}
	
	

}
