package wait_Element;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElement_SubmitButton_Wait {

	
	//@Before 
	/*
	 * System.setProperty("webdriver.chrome.driver", ".\\jar\\chromedriver_90.exe");
	 * WebDriver driver = new ChromeDriver(); driver.manage().window().maximize();
	 * driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	 * driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?")
	 * ;
	 */
	//@After
	//Test 
	
	@Test
	public void ListBox_Handling() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.com/2014/01/new-testing.html?");

		
		WebDriverWait wait = new WebDriverWait(driver, 2000);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@id=\"submitButton\"]"))));

		
		driver.findElement(By.xpath("//input[@id=\"submitButton\"]")).click();
		
		

	}

}
