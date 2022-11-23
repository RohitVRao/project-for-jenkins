package PomScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.BaseClass;
import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;
import com.LifeInsuranceManagementSystem.ObjectRepository.HomePage;
import com.LifeInsuranceManagementSystem.ObjectRepository.LoginPage;

public class SearchClientScript extends BaseClass{
	
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
	public void SearchClient() throws Throwable, Throwable
	{
		

		
		HomePage hp = new HomePage(driver);
		hp.searchclient(eLib.readDataFromExcel("searchClient", 0, 0));
		Thread.sleep(2000);

}
}
