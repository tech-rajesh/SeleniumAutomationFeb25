package controlSampleApplicationExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckboxRadioButtonExample {
	
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
		//close/quit
		
		
	}
	
	@Test
	public void handleCheckboxRadio() {
		
		//Checkobx
		driver.findElement(By.xpath("//input[contains(@value,'Bike')]")).click();
		
		//RadioButton
		
		//driver.findElement(By.xpath("//input[contains(@value,'female')]")).click();
		driver.findElement(By.xpath("(//input[contains(@name,'gender')])[2]")).click();
		
		
	}
	
	
	
	
	

}
