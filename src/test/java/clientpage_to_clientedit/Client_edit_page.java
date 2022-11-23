package clientpage_to_clientedit;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Client_edit_page {
	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
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
	 
	// WebDriver driver = new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get(URL);
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	 driver.findElement(By.name("username")).sendKeys(USERNAME);
	 driver.findElement(By.name("password")).sendKeys(PASSWORD);
	 driver.findElement(By.xpath("//button[text()='login']")).click();
	 
	 driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
	 driver.findElement(By.xpath("//a[text()='Edit']")).click();
	
	 driver.findElement(By.name("submit")).click();
	 driver.quit();	 
	 

}
}
