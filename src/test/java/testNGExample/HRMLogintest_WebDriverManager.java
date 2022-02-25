package testNGExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLogintest_WebDriverManager {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
		
		
//		WebDriverManager.edgedriver().setup();
//		driver = new EdgeDriver();
		
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		driver.manage().window().maximize();
	}
	
	@Test
	public void login() {
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	}

}
