package com.LifeInsuranceManagementSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentInformationPage {

	// declaration

	@FindBy(xpath = "//a[text()='Add Payment']")
	private WebElement AddPaymentBTN;

	// initialization

	// initialization

	public PaymentInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement getAddPaymentBTN() {
		return AddPaymentBTN;
	}

	// Business Libraries

	public void paymentInformationPage() {
		AddPaymentBTN.click();
	}

}
