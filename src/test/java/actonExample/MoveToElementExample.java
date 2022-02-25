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

public class MoveToElementExample {

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

		Thread.sleep(5000);
		driver.close();
		// close/quit

	}

	@Test
	public void RightClickTest() throws Exception {

		Thread.sleep(3000);
		WebElement SignIn = driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1"));
		WebElement wishList = driver.findElement(By.xpath("//span[text()='Create a Wish List']"));
		
		
		Actions act = new Actions(driver); 
		
		//Method1
		//act.moveToElement(SignIn).moveToElement(wishList).click().build().perform();
		
		//Method2
		act.moveToElement(SignIn).click(wishList).build().perform();
		
		
	}
	
	

}
