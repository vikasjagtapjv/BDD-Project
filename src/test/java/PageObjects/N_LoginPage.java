package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.Javascript;

public class N_LoginPage {
	public WebDriver ldriver;
	public Javascript js;
	
	public N_LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements( rdriver,this);
	}
	
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement txtUser;
	 
	@FindBy(how=How.XPATH,using="//input[@placeholder='Password']")
	WebElement txtPass;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']")
	WebElement clickLogin;
	
	@FindBy(how=How.XPATH,using="//a[text()='OrangeHRM, Inc']")
	WebElement clickWindow;
	/*
	 * #1. ABSTRACTION
Abstraction is the methodology of hiding the implementation of 
internal details and showing the 
functionality to the users.
Let’s see an example of data abstraction in Selenium Automation Framework.
In Page Object Model design pattern, 
we write locators (such as id, name, xpath etc.,) and the 
methods in a Page Class.
We utilize these locators in tests but we can’t see the implementation of the methods. 
Literally we hide the implementations of the locators from the tests.
	 */
	
	
	//Actions Method
	
	public void setUser(String userN)
	{
		txtUser.sendKeys(userN);
	}
	
	public void setPass(String pass)
	{
		txtPass.sendKeys(pass);
	}
	public void clickLgn()
	{
		clickLogin.click();
	}
	public void clickW()
	{
		
		clickWindow.click();
		
	}

}
