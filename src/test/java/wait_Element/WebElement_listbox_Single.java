package wait_Element;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebElement_listbox_Single {

	@Test
	public void ListBox_Handling() throws Exception {

		System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
		
		
		
		
		
		  WebDriverWait wait = new WebDriverWait(driver, 2000);
		  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("text3")));
		  
		  WebElement text_3 = driver.findElement(By.id("text3"));
		
		  text_3.sendKeys("Hello Team !!");
		
		

	}

}
