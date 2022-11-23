package com.LifeInsuranceManagementSystem.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class ExcelUtility extends JavaUtility {
public String readDataFromExcel(String sheetname, int RowNo, int ColumnNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	 
	 Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet(sheetname);
				
		Row ro = sh.getRow(RowNo);
		
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
}
public void WriteDataIntoExcel(String Sheetname, int RowNo, int ColumnNo, String data) throws EncryptedDocumentException, IOException {
	
	
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	 
	 Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet(Sheetname);
				
		Row ro = sh.getRow(RowNo);
		
		Cell cel = ro.getCell(ColumnNo);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExcelPath);
		wb.write(fos);
}

public int getLastRowNo(String Sheetname) throws EncryptedDocumentException, IOException
{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(Sheetname);
	int count = sh.getLastRowNum();
	return count;
}

public int getLastColumnNo(String Sheetname, int Rowno) throws EncryptedDocumentException, IOException
{
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(Sheetname);
	Row ro = sh.getRow(Rowno);
	int Colcount = ro.getLastCellNum();
	return Colcount;
}

/**
 * This method is used to getList
 * @author Rohit V Rao
 * @param SheetName
 * @param driver
 * @throws Throwable
 */

public void getList(String SheetName, WebDriver driver) throws Throwable {
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	int count = sh.getRow(1).getLastCellNum();
	
	for (int i = 0; i<count; i++) {
		String key = sh.getRow(0).getCell(i).getStringCellValue();
		String value = sh.getRow(1).getCell(i).getStringCellValue();
		driver.findElement(By.name(key)).sendKeys(value);
		
		}
}
	

	
public Map<String, String> getList(String SheetName) throws Throwable {
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	int count = sh.getRow(1).getLastCellNum();
	Map<String, String> map = new HashMap<String, String>();
	for (int i = 0; i<count; i++) {
		String key = sh.getRow(0).getCell(i).getStringCellValue();
		String value = sh.getRow(1).getCell(i).getStringCellValue();
		map.put(key, value);
		}
	return map;
}

public void getListForUpdate(String SheetName,WebDriver driver) throws Throwable {
	FileInputStream fi = new FileInputStream(IPathConstants.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	int count = sh.getRow(1).getLastCellNum();
	for (int i = 0; i<count; i++) {
		String key = sh.getRow(0).getCell(i).getStringCellValue();
		String value = sh.getRow(1).getCell(i).getStringCellValue();
		Thread.sleep(1000);
		driver.findElement(By.name(key)).clear();
		Thread.sleep(1000);
		driver.findElement(By.name(key)).sendKeys(value);
	}
}
	@DataProvider
	public Object[][] getDataFromExcel(String SheetName ) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int LastRow = sh.getLastRowNum()+1;
		int Lastcolumn = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[LastRow][Lastcolumn];
		
		for(int i =0; i< LastRow; i++)
		{
			for(int j =0; j< Lastcolumn; j++)
			{
			
			obj[i][j] = sh.getRow(i).getCell(j).getStringCellValue();
		    }
		}
	
	     return obj;
  }
}



