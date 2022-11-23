package practicepackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNG_Annotations {
	
	@BeforeSuite
	public void cricket ()
	{
		System.out.println("Rohit Sharma");
	}
	
	@BeforeClass
	public void football ()
	{
		System.out.println("Ronaldo");
	}
	
	@BeforeMethod
	public void basketball ()
	{
		System.out.println("curry");
	}
	
	@Test
	public void f1()
	{
		System.out.println("Hamilton");
	}
	
	@AfterMethod
	public void kabaddi ()
	{
		System.out.println("Rohit");
	}
	
	@BeforeMethod
	public void baseball ()
	{
		System.out.println("James");
	}
	
	@Test
	public void hockey()
	{
		System.out.println("Mithun");
	}
	
	@AfterMethod
	public void NFL ()
	{
		System.out.println("Shawn");
	}
	
	@AfterClass
	public void MotoGP ()
	{
		System.out.println("Marquez");
	}
	
	@AfterSuite
	public void Lagori()
	{
		System.out.println("Unknown");
	}
	
	

}
