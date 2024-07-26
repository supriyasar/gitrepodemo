package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import resources.Base;

public class RegisterTest extends Base {
	public WebDriver driver;

	@BeforeMethod
	public void openBrowser() throws IOException {
		System.out.println("Registering test started");
		
		System.out.println("SBranch Code updated");
		driver = InitializeBrowser();

	}

	@Test
	public void Registering() {
		System.out.println("Registering test");
	}

	@AfterMethod
	public void closeBrowser() {
		System.out.println("Registering test ended");
		driver.quit();
	}
}
