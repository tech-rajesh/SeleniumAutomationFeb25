package tests;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import configExample.ReadDataFromConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.NOPAddCustomer_PageFactory;
import pages.NOPHomePage;
import pages.NOPHomePage_PageFactory;

public class BaseTest {

	
	
	WebDriver driver;
	Logger log ;
	//NOPHomePage homePage;
	NOPHomePage_PageFactory homePageFactory;
	NOPAddCustomer_PageFactory addCustomerPageFactory;
	ReadDataFromConfigFile conf;

	@BeforeTest
	public void launchApp() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		
		//Read Data from Properties file
		conf = new ReadDataFromConfigFile();
		
		//homePage = new NOPHomePage(driver);
		homePageFactory = new NOPHomePage_PageFactory(driver);
		addCustomerPageFactory = new NOPAddCustomer_PageFactory(driver);
		
		//COnfig File
		
		log = Logger.getLogger("NOP_comm_Automation_Logger");
		PropertyConfigurator.configure("./configFolder/log4j.properties");
		
		
		log.info("Chrome Browser Launch Sucessfully");
		driver.get(conf.getAppURL());
		log.info("NOP comm application Launch Sucessfully in chrome browser");
	
		driver.manage().window().maximize();

	}

	@AfterTest
	public void closeApp() throws Exception {

		Thread.sleep(5000);
		driver.close();
		
		log.info("Closing chrome browser");
		// close/quit

	}
	
}
