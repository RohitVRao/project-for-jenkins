package practicepackage;

import org.testng.annotations.Test;

public class Batch_Execution_exp1 {
	
	@Test(groups = {"regression","functional"})
	public void India() {
		System.out.println("Bangalore");
	}

	@Test(groups = {"regression","smoke"})
	public void America() {
		System.out.println("NewYork");
	}


}
