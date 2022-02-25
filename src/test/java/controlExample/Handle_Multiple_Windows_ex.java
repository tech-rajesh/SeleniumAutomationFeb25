package controlExample;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handle_Multiple_Windows_ex {
	public static WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("http://only-testing-blog.blogspot.in/2014/01/textbox.html");
	}

	@AfterTest
	public void aftertest() {
		//driver.close(); 	// close current browser insta focus
		driver.quit();

	}

	@Test
	public void test() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String parenetWindow = driver.getWindowHandle();
		
		
		driver.findElement(By.xpath("//b[contains(.,'Open New Page')]")).click();

		
		
		// Get and store both window handles in array
		Set<String> AllWindowHandles = driver.getWindowHandles();
		
		
		
		String window1 = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);
		
		String window2 = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles.toArray()[1]);

		
		
		
		
		
		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(window2);

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("My Name");
		driver.findElement(By.xpath("//input[@value='Bike']")).click();
		driver.findElement(By.xpath("//input[@value='Car']")).click();
		driver.findElement(By.xpath("//input[@value='Boat']")).click();
		driver.findElement(By.xpath("//input[@value='male']")).click();
		Thread.sleep(5000);

		// Switch to window1(parent window) and performing actions on it.
		driver.switchTo().window(window1);

		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//option[@id='country6']")).click();
		driver.findElement(By.xpath("//input[@value='female']")).click();
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		
		
		
		driver.switchTo().window(window2);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Show Me Alert']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		

		driver.switchTo().window(parenetWindow);
		System.out.print("/nParent WIndow handle code = " + parenetWindow);
	}

}
