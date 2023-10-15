package stepDefination;



import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utilities.ReadConfig;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Steps extends BaseClass {
	
	
	@Given("User launch Chrome browser")
	public void user_launch_chrome_browsergetClass() {
		
		readData=new ReadConfig(driver);
		
		//readData=new ReadConfig(driver);
		log=LogManager.getLogger("Steps");
		String browser=readData.getBrowser();
		switch(browser.toLowerCase())
		{
		
		case "chrome":
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver-win32\\chromedriver.exe");
			driver=new ChromeDriver();
			break;
			
		case"firefox":
			System.setProperty("webdriver.gecko.driver",
					"F:\\Drivers\\geckodriver-v0.33.0-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			break;
		case"msedge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
			default:
				driver=null;
				break;
		}
		
		lp=new LoginPage(driver);
		log.info("chrome driver executable path set up");
	    
	}

	@When("User Opens URL {string}")
	public void user_opens_url(String URL) {
		//logger.info("Launching URL");
		driver.manage().window().maximize();
		driver.get(URL);
		log.info("Chrome browser launched");
		
	    
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String Email, String Pass) {
		//logger.info("Entering UserName");
		lp.setUserName(Email);
		log.info("email adress added");
		//logger.info("Entering Password");
		lp.setPassword(Pass);
		log.info("password entered");
	   
	}

	@When("click on Login")
	public void click_on_login() {
		//logger.info("click on Login button");
		lp.clickOnLogin(); 
		log.info("Clicked on login");
	   
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was Successful. "))
		{
			driver.close();
			log.info("login passed:page title matched");
			Assert.assertTrue(false);
		}
		else
		{
			log.info("Login failed: page title not matched");
			Assert.assertEquals(title, driver.getTitle());
		}
	  
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() throws InterruptedException {
		log.info("clicked on logout link");
		lp.logout();
		Thread.sleep(3000);
	    
	}

	@Then("close browser")
	public void close_browser() {
		log.info("Closing browser");
		driver.quit();
	   
	}
	//Customer features step definitions
	
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		log.info("Dashboard page opened");
		addCus=new AddCustomerPage(driver);
		//Assert.assertEquals("Dashboard / nopCommerce administration", addCus.getPageTitle());
		
	    
	}

	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
		log.info("clicked on customer menu");
		addCus.clickOnCustomerMainMenu();
	    
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(3000);
		log.info("clicked on customer menu item");

		addCus.customer_SubMenu();
	  
	}

	@When("Click on add new button")
	public void click_on_add_new_button() throws InterruptedException {
		log.info("clicked on add button");
		addCus.clickOnAddButton();
		Thread.sleep(2000);

	    
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		log.info("add new customer page opened ");
		String e_Title="Add a new customer / nopCommerce administration";
		String a_Title=driver.getTitle();
		Assert.assertEquals(e_Title,a_Title);
		//Assert.assertEquals("Add a new customer / nopCommerce administration",addCus.getPageTitle());
	   
	}

	@When("User Enter Customer info")
	public void user_enter_customer_info() throws InterruptedException {
		//logger.info("Adding new Customer");
		//logger.info("Providing customer Details");
		String email=reandomString()+"@gmail.com";
		addCus.setEmail(email);
		addCus.setFirstName("Viraj");
		addCus.setLastName("Jagtap");
		addCus.setPassword("abc@123");
		addCus.setCompany("xyz pvt ltd");
		//addCus.setCustomerRoll("Guests");
		Thread.sleep(3000);
		addCus.setDob("01/24/1995");
		addCus.setGender("Male");
		addCus.setManagerOfVendor("Vendor 2");
		//addCus.setNewsLetter("Your store name");
		//addCus.clickOnActive();
		addCus.clickOnTaxExempt();
		addCus.addAdminComment("This is for Testing ::::::::");
		
		log.info("customer all information entered Successfully");
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		log.info("Saving Customer Data");
		addCus.clickOnSave();
		Thread.sleep(5000);
	    
	}

	@Then("User can view Confirmation message {string}")
	public void user_can_view_confirmation_message(String message) {
		Assert.assertTrue(driver.findElement(By.tagName("body"))
				.getText().contains("The new customer has been added successfully"));
	     log.info("Confirmation message viewed");
	}
	
	//Steps for searching a customer using Email ID
	
	@When("Enter customers email")
	public void enter_customers_email() throws InterruptedException {
		custPage=new SearchCustomerPage(driver);
		//Thread.sleep(3000);
		custPage.setEmail("victoria_victoria@nopCommerce.com");
		log.info("mail entered");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		Thread.sleep(2000);
		custPage.clickOnSearch();
		log.info("Clicked on search");
		
	    
	}

	@Then("user should found Email in the search Table")
	public void user_should_found_email_in_the_search_table() {
		boolean status=custPage.searchCustomerByEmailAdress("victoria_victoria@nopCommerce.com");
	   Assert.assertEquals(true, status);
	   log.info("Emeil matched in table");
	}
	
	
	//Search customer by Name
	
	@When("Enter Customer First name")
	public void enter_customer_first_name() {
		custPage=new SearchCustomerPage(driver);
		custPage.setFirstName("Victoria ");
		log.info("First name entered Successfully");
	   
	}

	@When("Enter Customer Last name")
	public void enter_customer_last_name() throws InterruptedException {
		Thread.sleep(2000);
		custPage.setLastName("Terces");
		log.info("Last entered Successfully");
	    
	}

	@Then("User should found name in the search table")
	public void user_should_found_name_in_the_search_table() {
	boolean status=	custPage.searchCustomerByName("Victoria Terces");
	Assert.assertEquals(false,status);
	log.info("Name founded in searchbox");
	    
	}
	@AfterStep
	public void screenshot(Scenario scenario)
	{
		if(scenario.isFailed()) {
		byte [] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", scenario.getName());
		log.info("failed test cases screenshot captured");
		}
	}





}
