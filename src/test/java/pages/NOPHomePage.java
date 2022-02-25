package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NOPHomePage {

	WebDriver driver;

	// Identification Properties
	By txt_userName = By.name("Email");
	By txt_password = By.xpath("//input[@name='Password']");
	By btn_Login = By.xpath("//button[text()='Log in']");

	public NOPHomePage(WebDriver rdriver) {

		this.driver = rdriver;

	}

	public void enterUserName(String user) {

		driver.findElement(txt_userName).clear();
		driver.findElement(txt_userName).sendKeys(user);
		
	}

	public void enterPassword(String pass) {

		driver.findElement(txt_password).clear();
		driver.findElement(txt_password).sendKeys(pass);
		
	}
	
	
	public void clickLogin() {

		driver.findElement(btn_Login).click();;
		
		
	}

}
