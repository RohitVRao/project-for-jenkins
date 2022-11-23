package practicepackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CreateDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\LIMSEXCEL.xlsx");
		
		Workbook wb = WorkbookFactory.create(fi);
		
		Sheet sh = wb.getSheet("Sheet1");
		
		Row ro = sh.createRow(2);
		
		Cell cel = ro.createCell(2);
		cel.setCellValue("TestYantra");
		
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\LIMSEXCEL.xlsx");
		wb.write(fos);
		
        
		
		

	}

}
