package ReadDataFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ByForLoop {
	WebDriver driver;
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	@Test(dataProvider="UserInputData")
	public void testGoogle(String Keyword) {
		driver.get("https://www.google.com/");
		WebElement element=driver.findElement(By.xpath("//textarea[@name='q']"));
		element.sendKeys(Keyword);
		element.sendKeys(Keys.ENTER);
		
	} 
	@DataProvider(name="UserInputData")
	public Object[][]searchKeyword(){
		String fileName="C:\\Users\\Vikas\\Desktop\\testGoogle.xlsx";
		Object[][] inputData=getExcelData01(fileName,"Sheet1");
		return inputData;
	}
	public String[][]getExcelData01(String filename,String sheetName )
	{
		String [][] data01=null;
		try {
			FileInputStream fis=new FileInputStream(filename);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Sheet1");
			int row=sheet.getLastRowNum()+1;
			int cell=sheet.getRow(0).getLastCellNum();
			data01=new String[row-1][cell];
			for(int r=1;r<row;r++)
			{
				for(int c=0;c<cell;c++)
				{
					data01[r-1][c]=sheet.getRow(r).getCell(c).getStringCellValue();
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return data01;
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
		
	}
	
	

}
