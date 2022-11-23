package practicepackage;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class HardAssertions {

	@Test
	public void match()
	{
		System.out.println("pak vs eng");
		System.out.println("pak vs ind");
		assertNotEquals("A","B");
		System.out.println("ind vs eng");
		System.out.println("pak vs aus");
		System.out.println("sl vs eng");
		assertEquals("A","B");
		System.out.println("ned vs eng");
		System.out.println("pak vs zim");
	}
	    
	
	
}
