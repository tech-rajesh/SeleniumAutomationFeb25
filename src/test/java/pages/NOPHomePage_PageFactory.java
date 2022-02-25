package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NOPHomePage_PageFactory {

	WebDriver driver;

	// Identification Properties
//	By txt_userName = By.name("Email");
//	By txt_password = By.xpath("//input[@name='Password']");
//	By btn_Login = By.xpath("//button[text()='Log in']");
	
	@FindBy(name = "Email")
	WebElement txt_userName;
	
	@FindBy(xpath =  "//input[@name='Password']")
	WebElement txt_password;
	
	@FindBy(xpath = "//button[text()='Log in']")
	WebElement btn_Login;
	
	@FindBy(how = How.XPATH, using ="//button[text()='Log in']")
	WebElement btn_Login1;

	public NOPHomePage_PageFactory(WebDriver rdriver) {

		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	public void enterUserName(String user) {

		txt_userName.clear();
		txt_userName.sendKeys(user);
		
	}

	public void enterPassword(String pass) {

		txt_password.clear();
		txt_password.sendKeys(pass);
		
	}
	
	
	public void clickLogin() {

		btn_Login.click();;
		
		
	}

}
