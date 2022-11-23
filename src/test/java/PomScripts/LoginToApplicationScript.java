package PomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;
import com.LifeInsuranceManagementSystem.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;



public class LoginToApplicationScript {
	public static void main(String[] args) throws Throwable {
		FileUtility pLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebdriverUtility wLib = new WebdriverUtility();

		String BROWSER = pLib.readDataFromPropertyFile("Browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("Username");
		String PASSWORD = pLib.readDataFromPropertyFile("Password");

		
		
		 WebDriverManager.chromedriver().setup();
		
		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			System.out.println("invalid browser");

		}
		

		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);

		driver.get(URL);

		LoginPage lp = new LoginPage(driver);
		lp.loginPage(USERNAME, PASSWORD);

	}
}
