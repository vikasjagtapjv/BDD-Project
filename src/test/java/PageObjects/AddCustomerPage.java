package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefination.BaseClass;


public class AddCustomerPage extends BaseClass {
	WebDriver ldriver;
	//WaitHelper waitHelper;
	public  AddCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements( ldriver,this);
		//waitHelper=new WaitHelper(ldriver);
	}
	By customer_Mainmenu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By customerSubmenu=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	By addbutton =By.xpath("//a[@class='btn btn-primary']");
	By email=By.xpath("//input[@id='Email']");
	By passw=By.xpath("//input[@id='Password']");
	By firstN=By.xpath("//input[@id='FirstName']");
	By lastN=By.xpath("//input[@id='LastName']");
	By maleGendr=By.xpath("//input[@id='Gender_Male']");
	By femaleGendr=By.xpath("//input[contains(@id,'Gender_Female')]");
	By DOB =By.xpath("//input[@id='DateOfBirth']");
	By company=By.xpath("//input[@id='Company']");
	By taxExempt=By.xpath("//input[@id='IsTaxExempt']");
	
//	By newsletter=By.xpath("(//div[contains(@class,'k-multiselect-wrap k-floatwrap')])[1]");
//	By storeName=By.xpath("//li[contains(text(),'Your store name')]");
//	By testStore=By.xpath("//li[contains(text(),'Test store 2')]");
//	
	//By customerRoll=By.xpath("//select[@id='SelectedCustomerRoleIds']");
//	By registered=By.xpath("//li[contains(text(),'Registered')]");
//	By administrator=By.xpath("//li[contains(text(),'Administrators')]");
//	By moderator =By.xpath("//li[contains(text(),'Forum Moderators')]");
//	By guest=By.xpath("//li[contains(text(),'Guests')]");
//	By vendor=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By managerVendorId=By.xpath("//*[contains(@id,'VendorId')]");
	
	
	//By active=By.xpath("//input[contains(@id,'Active')]");
	By adminComment=By.xpath("//textarea[contains(@id,'AdminComment')]");
	By save=By.xpath("(//button[contains(@name,'save')])[1]");
	
	//Actions Method for each Element
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	
	public void clickOnCustomerMainMenu()
	{
		ldriver.findElement(customer_Mainmenu).click();
	}
	public void customer_SubMenu() {
		ldriver.findElement(customerSubmenu).click();
		
	}
	public void clickOnAddButton()
	{
		ldriver.findElement(addbutton).click();
	}
	public void setEmail(String Email) throws InterruptedException
	
	{
		Thread.sleep(3000);
		ldriver.findElement(email).sendKeys(Email);
	}
	
	public void setPassword(String Pass)
	{
		ldriver.findElement(passw).sendKeys(Pass);
	}
	public void setFirstName(String FirstN) throws InterruptedException
	{
		Thread.sleep(3000);
		ldriver.findElement(firstN).sendKeys(FirstN);
	}
	public void setLastName(String LastN) throws InterruptedException
	{
		Thread.sleep(3000);
		ldriver.findElement(lastN).sendKeys(LastN);
	}
	 
//	public void setCustomerRoll(String Text)throws InterruptedException
//	{
//		Select sec=new Select(ldriver.findElement(customerRoll));
//		sec.selectByVisibleText(Text);
//		
//	}
	public void setManagerOfVendor(String vendorValue)
	{
		Select se= new Select(ldriver.findElement(managerVendorId));
		se.selectByVisibleText(vendorValue);
	}
	public void setGender(String gendr)
	{
		if(gendr.equals("Male"))
		{
			ldriver.findElement(maleGendr).click();
		}
		else if(gendr.equals("Female"))
		{
			ldriver.findElement(femaleGendr).click();
		}
		else
		{
			ldriver.findElement(maleGendr).click();
		}
	}
	public void setDob(String dob)
	{
	
		ldriver.findElement(DOB).sendKeys(dob);
	}
	public void setCompany(String companys) {
		ldriver.findElement(company).sendKeys(companys);
	}
	public void clickOnTaxExempt() {
		ldriver.findElement(taxExempt).click();
	}
//	public void setNewsLetter(String letter) {
//		if(letter.equals("Your store name"))
//		{
//			ldriver.findElement(storeName).click();
//		}
//		else if(letter.equals("Test store 2"))
//		{
//			ldriver.findElement(testStore).click();
//		}
//		else {
//			ldriver.findElement(storeName).click();
//		}
//	}
//	public void clickOnActive()
//	{
//		ldriver.findElement(active);
//	}
	public void addAdminComment(String comment) {
		ldriver.findElement(adminComment).sendKeys(comment);
	}
	public void clickOnSave() throws InterruptedException
	{
		Thread.sleep(5000);
		ldriver.findElement(save).click();
	}
	
	

}
