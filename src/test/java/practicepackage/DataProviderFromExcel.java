package practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;

public class DataProviderFromExcel {
	
	@Test(dataProvider = "getData")
	public void players(String player_name, String country)
	{
		System.out.println(player_name + " " + " from " + country);
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		Object[][] value = elib.getDataFromExcel("dataproviders");
		return value;
	}
}
