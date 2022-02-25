package actonExample;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Right_DoubleClick {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		// close/quit

	}

	@Test
	public void RightClickTest() throws Exception {


		WebElement btnRightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
		
		
		Actions act = new Actions(driver); 
		
		//right click operation
		act.contextClick(btnRightClick).perform();
		
		driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();
		
		//handle alert
		String AlertText = driver.switchTo().alert().getText();
		System.out.println(AlertText);
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(AlertText, "clicked: delete");
		
		
	}
	
	@Test
	public void DoubleClickTest() throws Exception {


		WebElement btnDoubleClick = driver.findElement(By.xpath("//button[contains(text(),'Double-Click')]"));
		
		
		Actions act = new Actions(driver); 
		
		//right click operation
		act.doubleClick(btnDoubleClick).perform();
		
		
		
		//handle alert
		String AlertText = driver.switchTo().alert().getText();
		System.out.println(AlertText);
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
		Assert.assertEquals(AlertText, "You double clicked me.. Thank You..");
		
		
	}

}
