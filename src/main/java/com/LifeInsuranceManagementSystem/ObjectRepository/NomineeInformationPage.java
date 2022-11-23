package com.LifeInsuranceManagementSystem.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NomineeInformationPage {

	// declaration

	@FindBy(xpath = "//a[text()='Add Nominee']")
	private WebElement AddNomineeBTN;

	// initialization

	public NomineeInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization

	public WebElement getAddNomineeBTN() {
		return AddNomineeBTN;
	}

	// Business Libraries

	public void NomineeInfoPage() {
		AddNomineeBTN.click();
	}

}
