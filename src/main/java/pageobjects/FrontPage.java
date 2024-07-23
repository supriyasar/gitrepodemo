package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FrontPage {

	public FrontPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccountDropdown;
	
	public WebElement myAccountDropdown()
	{
		return myAccountDropdown;
	}
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	public WebElement loginOption()
	{
		return loginOption;
	}
}
