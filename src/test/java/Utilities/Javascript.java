package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Javascript {
	public WebDriver driver;
	
	public Javascript(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void scroll()
	{
		JavascriptExecutor jre= (JavascriptExecutor)driver;
		//jre.executeScript("window.scrollBy(0,400)","");
		//jre.executeScript("arguments[0].scrollIntoView();");
		//scrolling down at bottom of webpage
		
		//to perform scroll on an application using Selenium
		//scroll down to the bottom of the webpage using Selenium
		jre.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

}
