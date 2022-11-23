package clientsearch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Search_client {

	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("Browser");
		 String URL = pobj.getProperty("url");
		 String USERNAME = pobj.getProperty("Username");
		 String PASSWORD = pobj.getProperty("Password");
		 
		 WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("Chrome"))
		 {
			 driver = new ChromeDriver();
		 }
		 else if (BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("invalid browser");
			 
		 }
		 
		 //WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(URL);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.name("username")).sendKeys(USERNAME);
		 driver.findElement(By.name("password")).sendKeys(PASSWORD);
		 driver.findElement(By.xpath("//button[text()='login']")).click();
		 
		 Thread.sleep(2000);
		 
		 driver.findElement(By.name("key")).sendKeys("virat");
		 driver.findElement(By.xpath("//input[@class='searchBtn']")).click();
		 driver.quit();
		 
		 
		 
		 
	}

}
