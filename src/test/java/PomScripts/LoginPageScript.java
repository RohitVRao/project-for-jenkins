package PomScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.BaseClass;

public class LoginPageScript extends BaseClass{
	@Test
	public void Login()
	{
		
	}
}
//public static void main(String[] args) throws IOException {
//		
//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
//		Properties pobj = new Properties();
//		pobj.load(fis);
//		String BROWSER = pobj.getProperty("Browser");
//		 String URL = pobj.getProperty("url");
//		 String USERNAME = pobj.getProperty("Username");
//		 String PASSWORD = pobj.getProperty("Password");
//		 
//		 System.out.println(BROWSER);
//		 System.out.println(URL);
//		 System.out.println(USERNAME);
//		 System.out.println(PASSWORD);
//		 
//		 WebDriver driver = null;
//		 if(BROWSER.equalsIgnoreCase("Chrome"))
//		 {
//			 driver = new ChromeDriver();
//		 }
//		 else if (BROWSER.equalsIgnoreCase("firefox"))
//		 {
//			 driver = new FirefoxDriver();
//		 }
//		 else
//		 {
//			 System.out.println("invalid browser");
//			 
//		 }
//		 //WebDriver driver = new ChromeDriver();
//		 driver.manage().window().maximize();
//		 driver.get(URL);
//		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		 
//}
//}
