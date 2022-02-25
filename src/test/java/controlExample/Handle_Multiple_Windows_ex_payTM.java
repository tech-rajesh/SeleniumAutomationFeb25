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

public class Handle_Multiple_Windows_ex_payTM {
	public static WebDriver driver;

	@BeforeTest
	public void setup() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.irctc.co.in/nget/train-search");
	}

	@AfterTest
	public void aftertest() throws Exception {
		Thread.sleep(4000);
		// driver.close(); // close current browser insta focus
		driver.quit();

	}

	@Test
	public void test() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		String parentWindow = driver.getWindowHandle();

		// Click on OK button

		driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();

		Thread.sleep(4000);
		// Click on Hotel link
		driver.findElement(By.xpath("//a[contains(text(),'HOT')]")).click();

		// Get and store both window handles in array
		Set<String> AllWindowHandles = driver.getWindowHandles();

		String mainIRCTCWindow = (String) AllWindowHandles.toArray()[0];
		System.out.print("window1 handle code = " + AllWindowHandles.toArray()[0]);

		String hotelWindow = (String) AllWindowHandles.toArray()[1];
		System.out.print("\nwindow2 handle code = " + AllWindowHandles.toArray()[1]);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(hotelWindow);

		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		Thread.sleep(4000);

		// Switch to window2(child window) and performing actions on it.
		driver.switchTo().window(mainIRCTCWindow);
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(text(),'CONTACT US')]")).click();

	}

}
