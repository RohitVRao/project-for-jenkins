package com.LifeInsuranceManagementSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	// Declaration
	@FindBy(name = "username")
	private WebElement usernameTB;

	@FindBy(name = "password")
	private WebElement passwordTB;

	@FindBy(xpath = "//button[text()='login']")
	private WebElement submitBTN;

	// initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getusernameTB() {
		return usernameTB;
	}

	public WebElement getpasswordTB() {
		return passwordTB;
	}

	public WebElement getsubmitBTN() {
		return submitBTN;
	}

	// Business Libraries
	public void loginPage(String USERNAME, String PASSWORD) {
		usernameTB.sendKeys(USERNAME);
		passwordTB.sendKeys(PASSWORD);
		submitBTN.click();
	}

}
