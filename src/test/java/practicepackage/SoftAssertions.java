package practicepackage;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {

	@Test
	public void match()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("pak vs eng");
		System.out.println("pak vs ind");
		sa.assertEquals("A","B");
		System.out.println("ind vs eng");
		System.out.println("pak vs aus");
		System.out.println("sl vs eng");
		assertEquals("B","B","invalid");
		System.out.println("ned vs eng");
		System.out.println("pak vs zim");
	}
}
