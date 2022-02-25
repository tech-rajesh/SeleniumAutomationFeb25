package hrmLoginExample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import configExample.ReadDataFromConfigFile;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	
	@Test
	public void login() throws Exception 
	{
	
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//Create Object ReadDataFromConfigFile
		
		ReadDataFromConfigFile conf = new ReadDataFromConfigFile();
		System.out.println(conf.getAppURL());
		
		driver.get(conf.getAppURL());
		
		
		driver.findElement(By.name("txtUsername")).sendKeys(conf.getAdminUSer());
		driver.findElement(By.cssSelector("input#txtPassword")).sendKeys(conf.getAdminPassword());
		
		driver.findElement(By.id("btnLogin")).click();
		
		
		
		
	}
	
	

}
