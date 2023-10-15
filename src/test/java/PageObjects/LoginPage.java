package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefination.BaseClass;

public class LoginPage extends BaseClass{
	public WebDriver ldriver;
	 public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	@FindBy(xpath="//input[@id='Email']")
	@CacheLookup
	WebElement textEmail;
	@FindBy(xpath="//input[@id='Password']")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	WebElement clickOnButton;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement clickOnLogOut;
	
	

public void setUserName(String userName) {
	textEmail.clear();
	textEmail.sendKeys(userName);

	
}
public void setPassword(String pass)
{
	textPassword.clear();
	textPassword.sendKeys(pass);
	
}
public void clickOnLogin() {
	clickOnButton.click();
}
public void logout() {
	clickOnLogOut.click();
}

}