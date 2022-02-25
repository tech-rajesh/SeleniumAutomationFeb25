package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class NOPHomePageTest extends BaseTest {

	@Test
	public void verifyLogin() throws Exception {

		log.info("enter user Name - " + conf.getAdminUSer());

		homePageFactory.enterUserName(conf.getAdminUSer());
		Thread.sleep(2000);
		log.info("enter password  - " + conf.getAdminPassword());
		homePageFactory.enterPassword(conf.getAdminPassword());
		Thread.sleep(2000);
		log.info("click on Login button");
		homePageFactory.clickLogin();
		
		
		Thread.sleep(5000);
		
		addCustomerPageFactory.clickLogout();

	}

}
