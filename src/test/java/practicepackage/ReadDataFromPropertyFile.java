package practicepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		//step 1 : get java representation object of physical file
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		
		//step 2 : create object for properties class
		Properties pobj = new Properties();
		
		//step 3 : load the keys 
		pobj.load(fis);
		
		//step 4 : get the value using getProperty
		 String BROWSER = pobj.getProperty("Browser");
		 String URL = pobj.getProperty("url");
		 String USERNAME = pobj.getProperty("Username");
		 String PASSWORD = pobj.getProperty("Password");
		 
		 System.out.println(BROWSER);
		 System.out.println(URL);
		 System.out.println(USERNAME);
		 System.out.println(PASSWORD);
		 
		 WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(URL);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.name("username")).sendKeys(USERNAME);
		 driver.findElement(By.name("password")).sendKeys(PASSWORD);
		 driver.findElement(By.xpath("//button[text()='login']")).click();
		 driver.close();
		 
		 
		

	}

}
