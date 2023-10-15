package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utilities.WaitHelper;
import stepDefination.BaseClass;

public class SearchCustomerPage extends BaseClass{
	public WebDriver ldriver;
	WaitHelper waitHelper;
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
		waitHelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how=How.ID,using="SearchEmail")
	WebElement txtEmail;
	@FindBy(how=How.ID,using="SearchFirstName")
	WebElement txtFirstName ;
	@FindBy(how=How.ID,using="SearchLastName")
	WebElement txtLastName ;
	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	WebElement txtMonth;
	@FindBy(how=How.ID,using="SearchDayOfBirth")
	WebElement txtDay ;
	@FindBy(how=How.ID,using="SearchRegistrationDateFrom")
	WebElement txtRegistrationFrom;
	@FindBy(how=How.ID,using="SearchRegistrationDateTo")
	WebElement txtRegistrationTo;
	@FindBy(how=How.ID,using="SearchLastActivityFrom")
	WebElement txtActivityFrom;
	@FindBy(how=How.ID,using="SearchLastActivityTo")
	WebElement txtActivityTo;
	@FindBy(how=How.ID,using="SearchCompany")
	WebElement txtCompany ;
	@FindBy(how=How.ID,using="SearchIpAddress")
	WebElement txtIPAddress;
	@FindBy(how=How.XPATH,using="//div[@class='k-multiselect-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Registered')]")
	WebElement listRegistred;
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Administrators')]")
	WebElement listAdministrators;
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Forum Moderators')]")
	WebElement listForumModerator ;
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Guests')]")
	WebElement listGuests ;
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Vendors')]")
	WebElement listVendor;
	
	@FindBy(how=How.ID,using="search-customers")
	WebElement btnSearch ;

	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	WebElement table ;

	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;

	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumn ;
	
	
	
	//Action method
	public void setEmail(String email)
	{
		//waitHelper.waitForElement(txtEmail, 50);
		//txtEmail.clear();
		txtEmail.sendKeys(email);
	}
	
	
	
	public void clickOnSearch() {
		btnSearch.click();
		
	}
	public int getNoOfRows()
	{
		return(tableRows.size());
	}
	public int getNoOfColumns()
	{
		return(tableColumn.size());
	}
	public boolean searchCustomerByEmailAdress(String email)
	{
		boolean flag=false;
		for(int i=1;i<getNoOfRows();i++)
		{
			String emailId=table.
					findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			if(emailId.equals(email))
			{
				flag=true;
			}
		}
		return flag;
	}
	public void setFirstName(String firstN)
	{
		//waitHelper.waitForElement(txtFirstName, 50);
		//txtFirstName.clear();
		txtFirstName.sendKeys(firstN);
	}
	public void setLastName(String lastN)
	{ 
		//waitHelper.waitForElement(txtLastName, 50);
		//txtLastName.clear();
		txtLastName.sendKeys(lastN);
	}

	public boolean searchCustomerByName(String Name) {
		boolean flag=false;
		for(int i=1;i<getNoOfRows();i++)
		{
			String nme=table.
					findElement(By.xpath
							("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
			String names[]=nme.split(" ");
			if(names[0].equals("Virat")&&names[1].equals("Kohli")) {
				
				flag=true;
			}
			
			
		}
		return flag;
	}
	


}
