package com.LifeInsuranceManagementSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	// Declaration

	@FindBy(xpath = "//a[text()='Aegon Life']")
	private WebElement Homepagelink;

	@FindBy(xpath = "//a[text()='CLIENTS']")
	private WebElement Clientslink;

	@FindBy(xpath = "//a[text()='AGENTS']")
	private WebElement Agentslink;

	@FindBy(xpath = "//a[text()='POLICY']")
	private WebElement Policylink;

	@FindBy(xpath = "//a[text()='NOMINEE']")
	private WebElement Nomineelink;

	@FindBy(xpath = "//a[text()='PAYMENTS']")
	private WebElement Paymentslink;

	@FindBy(name = "key")
	private WebElement SearchTB;

	@FindBy(xpath = "//input[@class='searchBtn']")
	private WebElement SearchBTN;

	@FindBy(xpath = "//i[@class='fa fa-exclamation-circle fa-2x']")
	private WebElement LogoutBTN;

	// initialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getHomepagelink() {
		return Homepagelink;
	}

	public WebElement getClientslink() {
		return Clientslink;
	}

	public WebElement getAgentslink() {
		return Agentslink;
	}

	public WebElement getPolicylink() {
		return Policylink;
	}

	public WebElement getNomineelink() {
		return Nomineelink;
	}

	public WebElement getPaymentslink() {
		return Paymentslink;
	}

	public WebElement getSearchTB() {
		return SearchTB;
	}

	public WebElement getSearchBTN() {
		return SearchBTN;
	}

	public WebElement getLogoutBTN() {
		return LogoutBTN;
	}

	// Business Libraries

	public void searchclient(String CLIENTNAME) {
		SearchTB.sendKeys(CLIENTNAME);
		SearchBTN.click();
		
	}
		
		public void clickOnHomePage() {
		Homepagelink.click();
		}
		
		public void clickOnClientsPage() {
		Clientslink.click();
		}
		
		public void clickOnAgentsPage() {
		Agentslink.click();
		}
		
		public void clickOnPolicyPage() {
		Policylink.click();
		}
		
		public void clickOnNomineePage() {
		Nomineelink.click();
		}
		
		public void clickOnPaymentPage() {
		Paymentslink.click();
		}
		
		
		public void LogoutButton() {
		LogoutBTN.click();
		

	}

}
