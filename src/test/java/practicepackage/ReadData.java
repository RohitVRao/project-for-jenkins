package practicepackage;

import org.testng.annotations.Test;

import com.LifeInsuranceManagementSystem.GenericUtilities.ExcelUtility;

public class ReadData {
@Test(dataProviderClass = ExcelUtility.class,dataProvider = "DataPro")
public void read(String a, String b) throws Throwable
{
	Thread.sleep(2000);
	System.out.println(a+ " from " +b);
}
}
