package practicepackage;

import org.testng.annotations.Test;

public class Batch_Execution_exp2 {

	@Test(groups = {"smoke","functional"})
	public void England() {
		System.out.println("London");
	}

	@Test(groups = {"smoke"})
	public void Australia() {
		System.out.println("Sydney");
	}

}

