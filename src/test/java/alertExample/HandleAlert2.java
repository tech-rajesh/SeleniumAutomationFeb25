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

public class HandleAlert2 {
	
	WebDriver driver;

	@BeforeTest
	public void launchApp() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("file:///D:/Jar_files/sample_application/Test.html");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(3000);
		driver.close();
		// close/quit

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
		
		Assert.assertEquals(actualText, "Please enter your name:");
		Assert.assertTrue(actualText.contains("name"));
		
		
		//Send data to Prompt
		String enterName = "Priya";
		
		myAlert.sendKeys(enterName);
		
		
		
		//myAlert.dismiss();	
		myAlert.accept();
		//Methods - accept/dismiss/getText,sendKeys
		
		//extract value from webelement
		
		String actualOperationText = driver.findElement(By.xpath("//p[@id='demoPrompt']")).getText();
		System.out.println(actualOperationText);
		Assert.assertTrue(actualOperationText.contains(enterName));
		
		
		
	}
	
	
	

}
