package client_module;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Addclient {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		
		String BROWSER = pobj.getProperty("Browser");
		 String URL = pobj.getProperty("url");
		 String USERNAME = pobj.getProperty("Username");
		 String PASSWORD = pobj.getProperty("Password");
		 
		 WebDriver driver = null;
		 if(BROWSER.equalsIgnoreCase("Chrome"))
		 {
			 driver = new ChromeDriver();
		 }
		 else if (BROWSER.equalsIgnoreCase("firefox"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else
		 {
			 System.out.println("invalid browser");
			 
		 }
		 
		 //WebDriver driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(URL);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		 driver.findElement(By.name("username")).sendKeys(USERNAME);
		 driver.findElement(By.name("password")).sendKeys(PASSWORD);
		 driver.findElement(By.xpath("//button[text()='login']")).click();
		 
		 driver.findElement(By.xpath("//a[text()='CLIENTS']")).click();
		 driver.findElement(By.xpath("//a[@class='btn']")).click();
		 
		 

		 
		 FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\LIMSEXCEL.xlsx");
		 
		 Workbook wb = WorkbookFactory.create(fi);
			
			Sheet sh = wb.getSheet("Sheet1");
			int last_col = sh.getRow(1).getLastCellNum();
			
			Row ro = sh.getRow(1);
			
			Cell cel = ro.getCell(2);
			
			String value = cel.toString();
			
			ArrayList list = new ArrayList<String>();
			list.add("client_password");
			list.add("name");
			list.add("sex");
			list.add("birth_date");
			list.add("maritial_status");
			list.add("nid");
			list.add("phone");
			list.add("address");
			list.add("policy_id");
			list.add("nominee_name");
			list.add("nominee_sex");
			list.add("nominee_birth_date");
			list.add("nominee_nid");
			list.add("nominee_relationship");
			list.add("priority");
			list.add("nominee_phone");
			
			for(int i=0; i<last_col;i++)
			{
				String values = sh.getRow(1).getCell(i).getStringCellValue();
				driver.findElement(By.name((String) list.get(i))).sendKeys(values);
				
				
				
			}
			
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//			js.executeScript("window.scrollBy(0,-1500)");
//			WebElement ele = driver.findElement(By.xpath("//input[@name='fileToUpload']"));
//			Actions a = new Actions(driver);
//			Thread.sleep(3000);
//			a.moveToElement(ele).click().perform();
//			
//			
//			StringSelection s = new StringSelection("C:\\Users\\Rohit V Rao\\Downloads");
//			
//			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
//			
//			Robot r = new Robot();
//			
//			r.keyPress(KeyEvent.VK_CONTROL);
//			r.keyPress(KeyEvent.VK_V);	
		Thread.sleep(3000);
		File f1 = new File("./src/test/resources/download.jpg");
		String photopath = f1.getAbsolutePath();
		driver.findElement(By.xpath("//input[@name='fileToUpload']")).sendKeys(photopath);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.quit();
			}

	
		
	}


