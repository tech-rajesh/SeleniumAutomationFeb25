package controlExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonSearchTest2 {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.manage().window().maximize();
		
	}
	
	

	@AfterTest
	public void closeApp() throws Exception {
		
		Thread.sleep(3000);
		driver.close();
		//close/quit
		
		
	}
	
	@Test
	public void searchItem() throws Exception {
		driver.findElement(By.xpath("//input[@id='Email']")).clear();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("admin@yourstore.com");
		
		
		//password field
		WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
		
		//clear text
		txtPassword.clear();
		txtPassword.sendKeys("admin");
		
		//click on Login Button
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	
	
	
	
	

}
