package client_module;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;

public class Addclient2 {

	public static void main(String[] args) throws Throwable {
		FileUtility pLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();

		String BROWSER = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("Username");
		String PASSWORD = pLib.readDataFromPropertyFile("Password");

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");

		}

		// WebDriver driver = new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		
		driver.get(URL);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='login']")).click();

		driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		driver.findElement(By.xpath("//a[@class='btn']")).click();

		

		eLib.getList("Sheet1");
		
		Thread.sleep(3000);
		File f1 = new File("./src/test/resources/download.jpg");
		String photopath = f1.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys(photopath);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}

}
