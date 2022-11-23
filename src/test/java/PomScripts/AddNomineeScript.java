package PomScripts;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.BaseClass;
import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;
import com.LifeInsuranceManagementSystem.ObjectRepository.AddNomineePage;
import com.LifeInsuranceManagementSystem.ObjectRepository.HomePage;
import com.LifeInsuranceManagementSystem.ObjectRepository.LoginPage;
import com.LifeInsuranceManagementSystem.ObjectRepository.NomineeInformationPage;

public class AddNomineeScript extends BaseClass {

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
	public void AddNominee() throws Throwable {

		HomePage hp = new HomePage(driver);
		hp.clickOnNomineePage();

//			create object for Nominee Information Page
		NomineeInformationPage nip = new NomineeInformationPage(driver);
		nip.NomineeInfoPage();

		eLib.getList("Sheet3");
		AddNomineePage addNominee = new AddNomineePage(driver);
		Thread.sleep(3000);
		addNominee.addNomineepage(eLib.getList("Sheet3"), driver);
		Thread.sleep(3000);
		// addNominee.clickOnSubmitButtonToAddNominee();
	}
}
