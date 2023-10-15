package stepDefination;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import Utilities.ReadConfig;
import Utilities.WaitHelper;

public class BaseClass {
	public   WebDriver driver;
	public LoginPage lp;
	public AddCustomerPage addCus;
	public SearchCustomerPage custPage;
	public static Logger log;
	public ReadConfig readData;
	
	//Generating random String for Email
	public static String reandomString()
	{
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return (generateString);
	}
	
}
