package stepDefination;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.N_LoginPage;
import Utilities.ExtentReport;
import Utilities.Javascript;
import Utilities.Window_Handles;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

public class New_Login_Step extends N_BaseClass {
	
	
	@Given("Launch the ChromeBrowser")
	public void launch_the_chrome_browser() {
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver-win32\\chromedriver.exe");

		//System.setProperty("webdriver.chrome.driver", "F:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		 lps=new N_LoginPage (driver);
		 js=new Javascript(driver);
		 WindowH=new Window_Handles(driver);
		 extentR=new ExtentReport(driver);
	  
	}
	@When("Open the Url {string}")
	public void open_the_url(String Url) {
		
		driver.manage().window().maximize();
		driver.get(Url);
		
	   
	}

	@When("Enters the UserName")
	public void enters_the_user_name() throws InterruptedException {
		Thread.sleep(3000);
		lps.setUser("Admin");
	    
	}

	@When("Enters the Password")
	public void enters_the_password() throws InterruptedException {
		Thread.sleep(3000);
		lps.setPass("admin123");
	   
	}
	@When("Click on login")
	public void click_on_login() {
		lps.clickLgn();
	   
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		String E_Title="OrangeHRM";
		String A_Title=driver.getTitle();
		Assert.assertEquals(E_Title,A_Title);
	}

    @When("User click on OrangeHRM.Inc")
	public void user_click_on_orange_hrm_inc() throws InterruptedException {
    	Thread.sleep(3000);
    	js.scroll();
    	lps.clickW();
	  
	}

	@Then("Title should be\"OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM\"")
	public void title_should_be_orange_hrm_hr_software_free_open_source_hr_software_hrms_hris_orange_hrm() throws InterruptedException {
	//	Thread.sleep(3000);
		System.out.println("Next window opened");
		WindowH.handleW();
		extentR.generateExtentReport();
		//driver.close();
	}

	@AfterStep
	public void addScreenshot( Scenario scenario)
	{
		if(scenario.isFailed())
		{
		final byte[] Screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(Screenshot,"image/png",scenario.getName());
		}
	}



}
