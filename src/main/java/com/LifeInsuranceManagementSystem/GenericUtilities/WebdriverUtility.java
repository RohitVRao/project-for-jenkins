package com.LifeInsuranceManagementSystem.GenericUtilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This class is used to write webdriver specific methods
 * @author Rohit V Rao
 *
 */
public class WebdriverUtility {
public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

/**
 * This method is used wait until the element is visible
 * @author Rohit V Rao
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOf(element));
	
}

/**
 * This method is used to handle dropdown  by index
 * @author Rohit V Rao
 * @param element
 * @param Index
 */
public void select(WebElement element, int Index) {
	Select sel = new Select(element);
	sel.selectByIndex(Index);
}

/**
 * This method is used to handle dropdown  by value
 * @author Rohit V Rao
 * @param value
 * @param element
 */
public void select(String value, WebElement element) {
	Select sel = new Select(element);
	sel.selectByValue(value);
	
}

/**
 * This method is used to handle dropdown  by visibletext
 * @author Rohit V Rao
 * @param element
 * @param text
 */
public void select(WebElement element, String text) {
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
	
}
/**
* wait for page to load before indentifying any sychronized element in DOM [HTML-Docuent]
* @author Rohit V Rao
* @param driver
*/
public void waitForPageToLoad(WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}
/**
* wait for page to load before indentifying any assychronized[java scripts actions] element 
in DOM [HTML-Docuent]
*@author Rohit V Rao
* @param driver
*/
public void waitForPageToLoadForJSElement(WebDriver driver) {
driver.manage().timeouts().setScriptTimeout(10,TimeUnit.SECONDS);

}
/**
 * used to wait for element to be clickable in GUI , & check for specific element for every 500 
milli seconds
*@author Rohit V Rao
 * @param driver
 * @param element
 */
public void waitForElemnetToBeClickAble(WebDriver driver, WebElement element) {
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(ExpectedConditions.elementToBeClickable(element));

}
/**
 * used to wait for element to be clickable in GUI , & check for specific element for every 500 
milli seconds
*@author Rohit V Rao
 * @param driver
 * @param element
 * @param pollingTime in the form second
* @throws Throwable 
 */
public void waitForElementWithCustomTimeOut(WebDriver driver, WebElement element, int
pollingTime) throws Throwable {
FluentWait wait = new FluentWait(driver);
wait.pollingEvery(Duration.ofMillis(pollingTime));
wait.wait(20);
wait.until(ExpectedConditions.elementToBeClickable(element));
}

/**
* used to Switch to Any Window based on Window Title
* *@author Rohit V Rao
* @param driver
* @param partialWindowTitle
*/
public void swithToWindow(WebDriver driver , String partialWindowTitle) {
 Set<String> set = driver.getWindowHandles();
 Iterator<String> it = set.iterator();
 while (it.hasNext()) {
 String wID = it.next();
 driver.switchTo().window(wID);
 String currentWindowTitle = driver.getTitle();
 if(currentWindowTitle.contains(partialWindowTitle)) 
 {
 break;
 }
 }
 }
 /**
 * used to Switch to Alert Window & click on OK button
 * @author Rohit V Rao
 * @param driver
 */
 public void swithToAlertWindowAndAccpect(WebDriver driver) {
 driver.switchTo().alert().accept();
 }
 
 /**
 * used to Switch to Alert Window & click on Cancel button
 * @author Rohit V Rao
 * @param driver
 */
 public void swithToAlertWindowAndCancel(WebDriver driver) {
 driver.switchTo().alert().dismiss();

}
 /**
 * used to Switch to Frame Window based on index
 * @author Rohit V Rao
 * @param driver
 * @param index
 */
 public void swithToFrame(WebDriver driver , int index) {
 driver.switchTo().frame(index);

 }
 /**
 * used to Switch to Frame Window based on id or name attribute
 * @author Rohit V Rao
 * @param driver
 * @param id_name_attribute
 */
 public void swithToFrame(WebDriver driver , String id_name_attribute) {
 driver.switchTo().frame(id_name_attribute);
 }
 
 /**
  * This method is used to Switch to Frame based on address
  * @author Rohit V Rao
  */
     public void swithToFrame(WebDriver driver , WebElement address) {
	 driver.switchTo().frame(address);
 }
 
 /**
 * used to place mouse cursor on specified element
 * @author Rohit V Rao
 * @param driver
 * @param elemnet
 */
 public void mouseHoverOnElemnet(WebDriver driver , WebElement element)
 {
 Actions act = new Actions(driver);
 act.moveToElement(element).perform();
 }
 
 /**
 * used to right click on specified element
 * @author Rohit V Rao
 * @param driver
 * @param elemnet
 */
 public void rightClickOnElement(WebDriver driver , WebElement element)
 {
 Actions act = new Actions(driver);
 act.contextClick(element).perform();
 }
 /**
 * @author Rohit V Rao
 * @param driver
 * @param javaScript
 */
 public void executeJavaScript(WebDriver driver , String javaScript) {
 JavascriptExecutor js = (JavascriptExecutor)driver;
 js.executeAsyncScript(javaScript, null);
 }
  public void waitAndClick(WebElement element) throws InterruptedException
  {
  int count = 0;
  while(count<20) {
  try {
  element.click();
  break;
  }catch(Throwable e){
  Thread.sleep(1000);
  count++;
  }
  }
  }
  
  public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
  TakesScreenshot ts=(TakesScreenshot)driver;
  File src=ts.getScreenshotAs(OutputType.FILE);
  File dest=new File("./screenshot/"+screenshotName+".PNG");
  FileUtils.copyFile(src, dest);
  }
  
  /**
  * pass enter Key appertain in to Browser
  * @author Rohit V Rao
  * @param driver
  */
  public void passEnterKey(WebDriver driver) {
  Actions act = new Actions(driver);
  act.sendKeys(Keys.ENTER).perform();
  } 
  /**
   * This method is used to double click on element
   * @author Rohit V Rao
   */
  public void doubleClickAction(WebDriver driver, WebElement element) {
	  Actions act = new Actions(driver);
	  act.doubleClick(element).perform();
  }
  
  /**
   * This method is used to double click on webpage
   * @author Rohit V Rao
   */
  public void doubleClickOnWebPage(WebDriver driver) {
	  Actions act = new Actions(driver);
	  act.doubleClick().perform();
 }
  
  /**
   * This method is used to press enter key
   * @author Rohit V Rao
 * @throws AWTException 
   */
  public void enterKey(WebDriver driver) throws AWTException
  {
  Robot rb = new Robot();
  rb.keyPress(KeyEvent.VK_ENTER);
}
/**
 * This method is used to release the key
 * @author Rohit V Rao
 * @throws AWTException 
 */
  public void enterRelease(WebDriver driver) throws AWTException
  {
	  Robot rb = new Robot();
	  rb.keyRelease(KeyEvent.VK_ENTER);
  }
  /**
   * This method is used to drag and drop
   * *@author Rohit V Rao
   */
  public void dragAndDropElement(WebDriver driver, WebElement src,WebElement dest ) {
	  Actions act = new Actions(driver);
	  act.dragAndDrop(src, dest).perform();
	  
	 
  }
  
  /**
	 * This method will perform random scroll
	 * @author Rohit V Rao
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver, int y)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,"+y+")");
	}
	
	
	/**
	 * This method will scroll until specified element is found
	 * @author Rohit V Rao
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver, WebElement element)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+y+")", element);
		//jse.executeScript("argument[0].scrollIntoView()", element);
	}
	/**
	 * this method is used to maximize the window
	 * @author Rohit V Rao
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
}
 
