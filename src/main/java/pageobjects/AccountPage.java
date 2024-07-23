package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	public AccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Edit your account information")
	private WebElement editAccountInfoOpt;
	
	public WebElement editAccountInfoOpt()
	{
		return editAccountInfoOpt;
	}
	
}
