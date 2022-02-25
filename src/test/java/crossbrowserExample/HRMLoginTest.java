package crossbrowserExample;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HRMLoginTest extends BaseTest{
	
	
	
	@Test
	public void verifyLogin() throws Exception {
		
		
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		
		driver.findElement(By.name("Submit")).click();
		
		
		//verify Dahboard Present
		
		Boolean verifyDashBoard = driver.findElement(By.tagName("h1")).isDisplayed();
		Assert.assertTrue(verifyDashBoard);
		
		String actualDashBoardText = driver.findElement(By.tagName("h1")).getText();
		Assert.assertEquals(actualDashBoardText, "Dashboard");
		
		//CLick on Welcome
		driver.findElement(By.cssSelector("a#welcome")).click();
		
		Thread.sleep(4000);
		
		//CLick on Logout
		driver.findElement(By.linkText("Logout")).click();
		
		
	}
	
	

}
