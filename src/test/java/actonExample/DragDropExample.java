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

public class DragDropExample {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
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

		
		WebElement dragdropFrame = driver.findElement(By.tagName("iframe"));
		//WebElement dragdropFrame = driver.findElement(By.xpath("//iframe[contains(@src,'drop')]iframe"));
		//switch to frame
		
		//driver.switchTo().frame(0);
		driver.switchTo().frame(dragdropFrame);
		
		
		
		Thread.sleep(3000);
		WebElement source = driver.findElement(By.cssSelector("div#draggable"));
		WebElement target = driver.findElement(By.cssSelector("div#droppable"));
		
		
		Actions act = new Actions(driver); 
		
		//Method1
		//draganddrop
		//act.dragAndDrop(source, target).perform();
		
		//Method2
		
		act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		
	}
	
	

}
