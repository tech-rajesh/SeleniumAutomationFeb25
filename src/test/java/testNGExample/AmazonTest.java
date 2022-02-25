package testNGExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonTest {
	
	
	@BeforeTest
	public void launchApp() {
		System.out.println("launching app");
	}
	
	@AfterTest
	public void closingApp() {
		System.out.println("closingApp ");
	}
	
	//Priority - 
	//default - 0
	//same priority - alpha
	//Highest negative number - highest priority
	
	@Test(priority = -3, description = "Search Items on Amazon Application")
	public void searchItems() {
		System.out.println("Test case - searchItems");
	}
	
	
	@Test(priority = -2, enabled= false)
	public void addItemsToCart() {
		System.out.println("Test case - addItemsToCart");
	}
	
	@Test
	public void payment() {
		System.out.println("Test case - payment");
	}
	
	@Test
	public void logout() {
		System.out.println("Test case - logout");
	}
	
	@Test(priority = -100)
	public void login() {
		System.out.println("Test case - login");
	}

}
