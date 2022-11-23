package payment_module;

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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Addpayment {

	public static void main(String[] args) throws IOException, InterruptedException {
		
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
		 
		 driver.findElement(By.xpath("//a[text()='PAYMENTS']")).click();
		 driver.findElement(By.xpath("//a[text()='Add Payment']")).click();
		 
FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\LIMSEXCEL.xlsx");
		 
		 Workbook wb = WorkbookFactory.create(fi);
			
			Sheet sh = wb.getSheet("Sheet2");
			int last_col = sh.getRow(1).getLastCellNum();
			
			Row ro = sh.getRow(1);
			
			Cell cel = ro.getCell(2);
			
			String value = cel.toString();
			
			ArrayList list = new ArrayList<String>();
			list.add("client_id");
			list.add("month");
			list.add("amount");
			list.add("due");
			list.add("fine");
			
			for(int i=0; i<last_col;i++)
			{
				String values = sh.getRow(1).getCell(i).getStringCellValue();
				driver.findElement(By.name((String) list.get(i))).sendKeys(values);
			}
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			driver.quit();
			
		 
		 

	}

}
