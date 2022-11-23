package com.LifeInsuranceManagementSystem.ObjectRepository;

import java.util.Map;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddPaymentPage {

	// declaration
	@FindBy(xpath = "//input[@name='client_id']")
	private WebElement ClientidTB;

	@FindBy(xpath = "//input[@name='month']")
	private WebElement MonthTB;

	@FindBy(xpath = "//input[@name='amount']")
	private WebElement AmountTB;

	@FindBy(xpath = "////input[@name='due']")
	private WebElement DueTB;

	@FindBy(xpath = "//input[@name='fine']")
	private WebElement FineTB;

	@FindBy(xpath = "//input[@name='agent_id']")
	private WebElement AgentidTB;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement SubmitBtn;

	// initialization
	public AddPaymentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getClientidTB() {
		return ClientidTB;
	}

	public WebElement getMonthTB() {
		return MonthTB;
	}

	public WebElement getAmountTB() {
		return AmountTB;
	}

	public WebElement getDueTB() {
		return DueTB;
	}

	public WebElement getFineTB() {
		return FineTB;
	}

	public WebElement getAgentidTB() {
		return AgentidTB;
	}

	public WebElement getSubmitBtn() {
		return SubmitBtn;
	}

	// Business Libraries
	
		public void addPaymentpage(Map<String, String> map,WebDriver driver) {
			for (Entry<String, String> set : map.entrySet()) {
				driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
			}

//	public void addPaymentPage(String Clientid, String Month, String Amount, String Due, String Fine) {
//		ClientidTB.sendKeys(Clientid);
//		MonthTB.sendKeys(Month);
//		AmountTB.sendKeys(Amount);
//		DueTB.sendKeys(Due);
//		FineTB.sendKeys(Fine);
	}

	public void clickonsubmitbuttonToAddPayment() {
		SubmitBtn.click();
	}

}
