package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class BuyTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws IOException {
		System.out.println("Buying test started");
		System.out.println("Code updated by other user");
		
		driver = InitializeBrowser();
	}

	@Test
	public void buying() throws InterruptedException {
		System.out.println("Buying test");		
		driver.get(prop.getProperty("url"));
		Thread.sleep(3000);
		Assert.assertTrue(false);
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Buying test stopped");
		driver.quit();
	}
}
