package PomScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.BaseClass;
import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.FileUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.JavaUtility;
import com.LifeInsuranceManagementSystem.GenericUtilities.WebdriverUtility;
import com.LifeInsuranceManagementSystem.ObjectRepository.AddPaymentPage;
import com.LifeInsuranceManagementSystem.ObjectRepository.HomePage;
import com.LifeInsuranceManagementSystem.ObjectRepository.LoginPage;
import com.LifeInsuranceManagementSystem.ObjectRepository.PaymentInformationPage;

public class AddPaymentScript extends BaseClass {
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
	public void AddPayment() throws Throwable
	{
		

		HomePage hp = new HomePage(driver);
		hp.clickOnPaymentPage();
		
//		create object for payment information page
		PaymentInformationPage pip = new PaymentInformationPage(driver);
		pip.paymentInformationPage();
		
//		create object for add payment page
		eLib.getList("Sheet2");
        AddPaymentPage addPayment = new AddPaymentPage(driver);
		addPayment.addPaymentpage(eLib.getList("Sheet2"), driver);
		Thread.sleep(2000);
		//addPayment.clickonsubmitbuttonToAddPayment();
		
	}
}


