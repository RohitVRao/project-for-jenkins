package practicepackage;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromTable {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\LIMSEXCEL.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		int a = wb.getSheet("Sheet1").getLastRowNum();
		System.out.println(a);
		
		for (int i=1; i<=a; i++)
		{
			String username = wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			       String password = wb.getSheet("Sheet1").getRow(i).getCell(2).getStringCellValue();
			       String team = wb.getSheet("Sheet1").getRow(i).getCell(3).getStringCellValue(); 
			    
			       System.out.println(username+"  "+password+ "  "+team);
		}

	}

}
