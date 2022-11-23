package com.LifeInsuranceManagementSystem.GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.LifeInsuranceManagementSystem.ObjectRepository.HomePage;
import com.LifeInsuranceManagementSystem.ObjectRepository.LoginPage;

public class BaseClass {

	public static WebDriver sdriver;
	public DatabaseUtility dLib = new DatabaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebdriverUtility wLib = new WebdriverUtility();
	public WebDriver driver = null;

	@BeforeSuite
	public void connectToDB() throws Throwable {
		dLib.connecttoDB();
		System.out.println("==== connect to database");
	}
//@Parameters("Browsername")
	@BeforeClass
	public void launchBrowser() throws Throwable {
		String BROWSER = fLib.readDataFromPropertyFile("Browser");
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid Browser");
		}

		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		String URL = fLib.readDataFromPropertyFile("url");
		sdriver=driver;
		driver.get(URL);
	}
	

	@BeforeMethod
	public void loginToApp() throws Throwable {
		String USERNAME = fLib.readDataFromPropertyFile("Username");
		String PASSWORD = fLib.readDataFromPropertyFile("Password");
		LoginPage lg = new LoginPage(driver);
		lg.loginPage(USERNAME, PASSWORD);
		System.out.println("Login to app");
	}

	@AfterMethod
	public void signout() {
		HomePage hp = new HomePage(driver);
		hp.getLogoutBTN();
		System.out.println("Logout from the app");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("closes the browser");
	}

	@AfterSuite
	public void lala() throws Throwable {
		dLib.closeDB();
		System.out.println("closes the database");
	}

}
