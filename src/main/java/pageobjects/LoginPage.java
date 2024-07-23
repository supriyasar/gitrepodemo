package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "input-email")
	private WebElement txtEmailAddress;
	
	public WebElement txtEmailAddress()
	{
		return txtEmailAddress;
	}
	
	@FindBy(id = "input-password")
	private WebElement txtPassword;
	
	public WebElement txtPassword()
	{
		return txtPassword;
	}
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement btnLogin;
	
	public WebElement btnLogin()
	{
		return btnLogin;
	}
}
