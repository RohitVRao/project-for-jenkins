package practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;

public class DataPro {
	@Test(dataProvider = "getData")
	public void players(String player_name, String country)
	{
		System.out.println(player_name + " from " + country);
	}
	
//	@DataProvider
//	public Object[][] getData() throws Throwable {
//		ExcelUtility elib = new ExcelUtility();
//		Object[][] val = elib.getDataFromExcel();
//		return val;
//	}
//	

}
