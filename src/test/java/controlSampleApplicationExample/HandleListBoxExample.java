package controlSampleApplicationExample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleListBoxExample {
	
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
	
	//@Test
	public void listbox() throws Exception {
		
		
		
		WebElement mylistbox = driver.findElement(By.xpath("//select[contains(@name,'FromLB')]"));
	
		Select list = new Select(mylistbox);
		
		
		
		System.out.println("verify list support multiple section or not : " +list.isMultiple());
		
		//Select value from listbox
		//Indexing start from 0
		list.selectByIndex(0);				//USA
		list.selectByValue("Spain");		//Spain
		list.selectByVisibleText("India");	//India
		
		Thread.sleep(2000);
		
		list.deselectByIndex(7);				//USA
		Thread.sleep(2000);
		list.deselectByVisibleText("USA");
		
	}
	
	
	@Test
	public void listbox2() throws Exception {
		
		
		
		WebElement mylistbox = driver.findElement(By.xpath("(//select)[1]"));
	
		Select list = new Select(mylistbox);
		
		
		
		System.out.println("verify list support multiple section or not : " +list.isMultiple());
		
		//Select value from listbox
		//Indexing start from 0
		Thread.sleep(2000);
		list.selectByIndex(5);					//Saab
		Thread.sleep(2000);
		list.selectByValue("Singapore");		//Opel
		Thread.sleep(2000);
		list.selectByVisibleText("Toyota");		//Toyota
		
		
		
	}
	
	
	

}
