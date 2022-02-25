package alertExample;

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

public class HandleAlert {
	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.com/2013/11/new-test.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(3000);
		driver.close();
		// close/quit

	}
	
	
	@Test
	public void verifyAlertText_SimpleAlert() throws Exception {
		
		//click on show me alert button
		driver.findElement(By.xpath("//input[@value=\"Show Me Alert\"]")).click();
		
		Thread.sleep(4000);
		//handle alert - switchTo
		//Alert/window/frame
		
		Alert myAlert = driver.switchTo().alert();
		
		String actualText = myAlert.getText();
		System.out.println(actualText);
		
		
		//validation Step
		
		Assert.assertEquals(actualText, "Hi.. This is alert message!");
		
		
		
		
		
		//myAlert.accept();			//click on "OK" button on alert
		myAlert.dismiss();	
		//Methods - accept/dismiss/getText,sendKeys
		
		
	}
	
	
	@Test
	public void verifyConfirmAlert() throws Exception {
		
		//click on show me alert button
		driver.findElement(By.xpath("//*[contains(text(),'Conf')]")).click();
		
		Thread.sleep(4000);
		//handle alert - switchTo
		//Alert/window/frame
		
		Alert myAlert = driver.switchTo().alert();
		
		String actualText = myAlert.getText();
		System.out.println(actualText);
		
		
		//validation Step
		
		Assert.assertEquals(actualText, "Press 'OK' or 'Cancel' button!");
		Assert.assertTrue(actualText.contains("'OK' or 'Cancel'"));
		
		//myAlert.dismiss();	
		myAlert.accept();
		//Methods - accept/dismiss/getText,sendKeys
		
		
		String actualOperationText = driver.findElement(By.xpath("//div[@id='demo']")).getText();
		System.out.println("Text Operation: " +actualOperationText);
		
		//Validation Step
		//Assert.assertEquals(actualOperationText, "You pressed Cancel!");
		Assert.assertTrue(actualOperationText.contains("OK"));
		
		
		
	}
	
	@Test
	public void verifyPromptAlert() throws Exception {
		
		//click on show me alert button
		driver.findElement(By.xpath("//button[contains(text(),'Prompt')]")).click();
		
		Thread.sleep(4000);
		//handle alert - switchTo
		//Alert/window/frame
		
		Alert myAlert = driver.switchTo().alert();
		
		String actualText = myAlert.getText();
		System.out.println(actualText);
		
		
		//validation Step
		
		Assert.assertEquals(actualText, "Your Name Please");
		Assert.assertTrue(actualText.contains("Name"));
		
		
		//Send data to Prompt
		
		myAlert.sendKeys("Abhijit");
		
		
		
		//myAlert.dismiss();	
		myAlert.accept();
		//Methods - accept/dismiss/getText,sendKeys
		
		
		
		
		
		
	}
	
	
	

}
