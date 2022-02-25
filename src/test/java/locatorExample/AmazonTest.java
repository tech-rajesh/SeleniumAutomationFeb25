package locatorExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
	}
	
	

	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(3000);
		driver.close();
		//close/quit
		
		
	}
	
	@Test
	public void searchItem() {
		
		driver.findElement(By.xpath("//h2[text()='Up to 70% off | Clearance store']//parent::div//following-sibling::div[@class='a-cardui-footer']/a")).click();;
		
		System.out.println(driver.getTitle());
		
	}
	
	
	
	
	

}
