package Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Window_Handles {
	public WebDriver driver;
	public Window_Handles(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
		public void handleW() {
//		String Id=driver.getWindowHandle();
//		System.out.println(Id);
		
		Set<String> Ids=driver.getWindowHandles();
		
		Iterator<String> it=Ids.iterator();
		String parentId=it.next();
		System.out.println(parentId);
		String ChildId=it.next();
		System.out.println(ChildId);
		for( String swindow:Ids)
		{
			String title=driver.switchTo()
					.window(swindow).getTitle();
			if(title.equals("OrangeHRM")||title.
					equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
			{
				driver.close();
			}
			
		}
		
	}

}
