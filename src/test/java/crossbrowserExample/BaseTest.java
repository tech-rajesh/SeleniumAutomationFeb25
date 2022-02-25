package crossbrowserExample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	WebDriver driver;

	@Parameters("browserName")
	@BeforeTest
	public void launchApp(String browser) {

		// Browser configuration

		// String browser = "firefox";

		if (browser.equalsIgnoreCase("chrome")) {

			// Execution on Chrome browser
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("edge")) {

			// Execution on edge browser -
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		
		else if (browser.equalsIgnoreCase("firefox")) {

			// Execution on edge browser -
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		else {

			// Execution on firefox browser -
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		// close/quit

	}

}
