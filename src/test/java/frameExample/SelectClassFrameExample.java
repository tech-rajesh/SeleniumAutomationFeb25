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

public class SelectClassFrameExample {
	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/support/ui/Select.html");
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
		
				
		//WebElement
		//WebElement myFrame = driver.findElement(By.tagName("iframe"));
		WebElement packageFrame = driver.findElement(By.xpath("//iframe[@name='packageFrame']"));
		
		driver.switchTo().frame(packageFrame);
		
		
		//------------------------------------------------------//
		
		//Get Attribute property from Actions
		WebElement lnkAction = driver.findElement(By.linkText("Actions"));
		
		String hrefAction = lnkAction.getAttribute("href");
		System.out.println(hrefAction);
		
		
		//Click on Action
		lnkAction.click();
		
		//------------------------------------------------------//
		
		
		
		
	}
	
	
	

}
