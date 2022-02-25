package dataDrivenTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMLoginTest {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	
	@AfterTest
	public void closeApp() throws Exception {
		Thread.sleep(4000);
		driver.close();
		
	}

	@Test(dataProvider = "TCS_RegressionData")
	public void verifyLoginWIthInValid(String user, String pass) throws Exception {
		
		Thread.sleep(2000);
		driver.findElement(By.name("txtUsername")).clear();
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		
		Thread.sleep(2000);
		driver.findElement(By.name("txtPassword")).clear();
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		
		Thread.sleep(2000);
		driver.findElement(By.name("Submit")).click();
		
		Thread.sleep(2000);
		//Validation Step
		String actualErrorMessage = driver.findElement(By.id("spanMessage")).getText();
		Assert.assertEquals(actualErrorMessage, "Invalid credentials");
		
	}
	
	@DataProvider(name = "TCS_SampleData")
	public Object [][] sampleData() {
		
		Object [][] data = {{"krishna@gmail.com", "password@1"}, {"Abhishek@gmail.com", "test@123"}, {"Vaibhav@gmail.com", "demo@123"}};
		return data;
		
	}
	
	
	@DataProvider(name = "TCS_RegressionData")
	public Object [][] RegressionData() {
		
		Object [][] data = {{"krishna1@gmail.com", "password@1"}, {"Abhishek1@gmail.com", "test@123"}, {"Vaibhav1@gmail.com", "demo@123"}};
		return data;
		
	}
	
}
