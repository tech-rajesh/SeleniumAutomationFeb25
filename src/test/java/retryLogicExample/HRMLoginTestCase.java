package retryLogicExample;



import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTestCase {
	
	
	
	
	@Test
	public void login() {
		
		System.out.println("Search Test Case");
	}

	

	//@Test(retryAnalyzer = RetryLogic.class)
	
	@Test
	public void verifyDashBoard() {
		
		System.out.println("verifyDashBoard Test Case");
		Assert.assertTrue(false);
	}

	
	

	@Test
	public void logout() {
		
		System.out.println("logout Test Case");
		
	}

	


}
