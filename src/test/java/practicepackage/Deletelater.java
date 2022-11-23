package practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;

public class Deletelater {
	
	@Test(dataProvider = "getData")
	public void players(String player_name,String skills,String country)
	{
		System.out.println(player_name + " is a good " + skills + " from " + country);
	}

	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility elib = new ExcelUtility();
		Object[][] value = elib.getDataFromExcel("Sheet4");
		return value;
	}
}


