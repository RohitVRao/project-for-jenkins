package client_module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;

public class update_client_details {

	public static void main(String[] args) throws Throwable {
		// create objects for generic libraries

		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();

		// read data from property file
		String BROWSER = fLib.readDataFromPropertyFile("Browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("Username");
		String PASSWORD = fLib.readDataFromPropertyFile("Password");

		WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='login']")).click();

		// add client
		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//a[text()='Edit'])[2]")).click();

		eLib.getListForUpdate("Sheet3", driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.close();
	}


	}


