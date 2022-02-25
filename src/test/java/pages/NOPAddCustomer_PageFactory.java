package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NOPAddCustomer_PageFactory {

	WebDriver driver;

	// Identification Properties
//	By txt_userName = By.name("Email");
//	By txt_password = By.xpath("//input[@name='Password']");
//	By btn_Login = By.xpath("//button[text()='Log in']");
	
	@FindBy(linkText =  "Logout")
	WebElement lnklogout;
	
	

	public NOPAddCustomer_PageFactory(WebDriver rdriver) {

		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	
	
	public void clickLogout() {

		lnklogout.click();;
		
		
	}

}
