package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ReadConfig {
public WebDriver driver;
public Properties pro;
String path="config.properties";
	
	public ReadConfig(WebDriver driver)
	{
		try {
		pro=new Properties();
		FileInputStream fis = new FileInputStream(path);
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public String getBrowser()
	{
		String value=pro.getProperty("browser");
		if(value!=null)
		{
			return value;
		}
		else
		{
			throw new RuntimeException("url not specified in config file");
		}
	}


}
