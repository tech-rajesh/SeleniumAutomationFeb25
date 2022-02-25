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

public class DragDropExample2 {

	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		// close/quit

	}

	@Test
	public void DragDropTest() throws Exception {

		
		WebElement dragdropFrame = driver.findElement(By.xpath("//iframe[contains(@data-src,'droppable/photo')]"));
		//WebElement dragdropFrame = driver.findElement(By.xpath("//iframe[contains(@src,'drop')]iframe"));
		//switch to frame
		
		//driver.switchTo().frame(0);
		driver.switchTo().frame(dragdropFrame);
		
		
		
		Thread.sleep(3000);
		WebElement img2 = driver.findElement(By.xpath("//img[contains(@src,'tatras2')]"));
		WebElement img3 = driver.findElement(By.xpath("//img[contains(@src,'tatras3')]"));
		
		WebElement target = driver.findElement(By.cssSelector("div#trash"));
		
		
		Actions act = new Actions(driver); 
		
		//Method1
		//draganddrop
		act.dragAndDrop(img2, target).perform();
		act.dragAndDrop(img3, target).perform();
		
		//Method2
		
		//act.clickAndHold(source).moveToElement(target).release().build().perform();
		
		
	}
	
	

}
