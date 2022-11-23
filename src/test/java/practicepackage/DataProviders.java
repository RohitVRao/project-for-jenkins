package practicepackage;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviders {
	
	@Test(dataProvider = "getData")
	public void travel(String src, String dest) {
		System.out.println(src + " to " + dest);
	}
	

	@DataProvider
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "bangalore";
		obj[0][1] = "australia";
		
		
		obj[1][0] = "australia";
		obj[1][1] = "england";
		
		obj[2][0] = "england";
		obj[2][1] = "srilanka";		
		
		return obj;
		
				}
	
}
