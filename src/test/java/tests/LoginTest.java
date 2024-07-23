package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.AccountPage;
import pageobjects.FrontPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base {
	public WebDriver driver;
	Logger log;

	@BeforeMethod
	public void openBrowser() throws IOException {
		log = LogManager.getLogger(this);
		log.info("LoginTest Started");
		log.debug("LoginTest Started");

		driver = InitializeBrowser();
		log.debug("InitializeBrowser finished");
	}

	@DataProvider
	public Object[][] getLoginData() {
		Object data[][] = { { "abc.efg@gmail.com", "password" }, { "123.efg@gmail.com", "password" } };
		return data;
	}

	@Test(dataProvider = "getLoginData")
	public void Login(String emailid, String password) throws InterruptedException {
		driver.get(prop.getProperty("url"));

		FrontPage frontpageobj = new FrontPage(driver);
		frontpageobj.myAccountDropdown().click();

		frontpageobj.loginOption().click();

		LoginPage loginpageobj = new LoginPage(driver);

		// String emailid = prop.getProperty("emailid");
		loginpageobj.txtEmailAddress().sendKeys(emailid);

		// String password = prop.getProperty("password");
		loginpageobj.txtPassword().sendKeys(password);

		loginpageobj.btnLogin().click();

		AccountPage accountpage = new AccountPage(driver);
		try {
			if (accountpage.editAccountInfoOpt().isDisplayed())
				log.debug("Login Successful");
		} catch (Exception e) {
			log.debug("Login Failed");
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		log.debug("closeBrowser");
	}
}
