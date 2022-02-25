package javascriptExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		// close/quit

	}

	@Test
	public void searchItem() throws Exception {


		WebElement retrunPolicy = driver.findElement(By.xpath("//strong[contains(text(),'Return within 30days')]"));
		
		JavascriptExecutor JS = (JavascriptExecutor) driver;
		JS.executeScript("arguments[0].scrollIntoView();", retrunPolicy);
		
		Thread.sleep(2000);
		
		
		WebElement lnkReturn = driver.findElement(By.xpath("//a[@href=\"/faqs#returns\"]"));
		JS.executeScript("arguments[0].click();", lnkReturn);
	}

}
