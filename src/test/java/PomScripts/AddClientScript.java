package PomScripts;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.BaseClass;
import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;
import com.LifeInsuranceManagementSystem.ObjectRepository.AddClientPage;
import com.LifeInsuranceManagementSystem.ObjectRepository.ClientInformationPage;
import com.LifeInsuranceManagementSystem.ObjectRepository.HomePage;
import com.LifeInsuranceManagementSystem.ObjectRepository.LoginPage;
@Listeners(com.LifeInsuranceManagementSystem.GenericUtilities.ListnersImplementationClass.class)
public class AddClientScript extends BaseClass {
	
//	public static void main(String[] args) throws Throwable {
//		FileUtility pLib = new FileUtility();
//		ExcelUtility eLib = new ExcelUtility();
//		JavaUtility jLib = new JavaUtility();
//		WebdriverUtility wLib = new WebdriverUtility();
//
//		String BROWSER = pLib.readDataFromPropertyFile("Browser");
//		String URL = pLib.readDataFromPropertyFile("url");
//		String USERNAME = pLib.readDataFromPropertyFile("Username");
//		String PASSWORD = pLib.readDataFromPropertyFile("Password");
//
//		WebDriver driver = null;
//		if (BROWSER.equalsIgnoreCase("Chrome")) {
//			driver = new ChromeDriver();
//		} else if (BROWSER.equalsIgnoreCase("firefox")) {
//			driver = new FirefoxDriver();
//		} else {
//			System.out.println("invalid browser");
//
//		}
//
//		// WebDriver driver = new ChromeDriver();
//		wLib.maximizeWindow(driver);
//		wLib.waitForPageLoad(driver);
//
//		driver.get(URL);
//
//		LoginPage lp = new LoginPage(driver);
//		lp.loginPage(USERNAME, PASSWORD);
	
	@Test
	public void AddClient() throws Throwable
	{

		HomePage hp = new HomePage(driver);
		Assert.fail();
		hp.clickOnClientsPage();

		ClientInformationPage cip = new ClientInformationPage(driver);
		cip.ClickAddclientButton();

		//eLib.getList("Sheet1");
		AddClientPage addclient = new AddClientPage(driver);
		addclient.addClientPage(eLib.getList("Sheet1"), driver);

		File f1 = new File("./src/test/resources/download.jpg");
		String photopath = f1.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys(photopath);
		Thread.sleep(3000);
		// addclient.clickOnSubmitButton();
	}

}
