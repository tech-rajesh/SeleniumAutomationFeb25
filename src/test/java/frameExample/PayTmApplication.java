package frameExample;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PayTmApplication {
	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://paytm.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		// close/quit

	}
	
	
	
	@Test
	public void clickOnWatchVideo() throws Exception {
		
		WebElement btnSignIn = driver.findElement(By.xpath("//span[text()='Sign In']"));
		btnSignIn.click();
		
		
		Thread.sleep(5000);
		
		WebElement myFrameXPATH = driver.findElement(By.xpath("//iframe[contains(@src,'Iframe')]"));
		
		driver.switchTo().frame(myFrameXPATH);
		
		
		//------------------------------------------------------//
		
		
		//Get test from frame
		String frameText = driver.findElement(By.className("heading")).getText();
		System.out.println(frameText);
		
		Assert.assertTrue(frameText.contains("Paytm Web account"));
		
		//Click on Watch Video
		WebElement lnkWatchVideo = driver.findElement(By.xpath("//span[contains(text(),'Watch Video')]"));
		lnkWatchVideo.click();
		
		
	}
	
	
	

}
