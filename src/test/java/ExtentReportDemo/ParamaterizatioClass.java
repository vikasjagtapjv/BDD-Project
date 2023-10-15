package ExtentReportDemo;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamaterizatioClass {
	WebDriver driver;
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32 (1)\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test(dataProvider="dataForLogin")
	public void inputKey(String UserName,String Id) {
		WebElement Login=driver.findElement(By.xpath("//input[@id='email']"));
		Login.sendKeys(UserName);
		WebElement pass=driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys(Id);
		driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
		
		
		
	}
	@DataProvider(name="dataForLogin")
	public Object[][]loginDataProvider(){
		String filename="F:\\Salary-Slip.xlsx";
		Object[][] loginData=getExcelData(filename,"Sheet2" );
//		loginData[0][0]="Vikas Jagtap";
//		loginData[0][1]="Mh21@m5753";
//		loginData[1][0]="Viraj Jagtap";
//		loginData[1][1]="Mh23@m5753";
		return loginData;
		
	}
	
	public String[][] getExcelData(String fileName,String sheetName)
	{
		String[][] data=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook workbook=new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet("Sheet2");
			int row =sheet.getLastRowNum()+1;
			int cell=sheet.getRow(0).getLastCellNum();
			data= new String[row-1][cell];
			for(int r=1;r<=row;r++)
			{
				for(int c=0;c<cell;c++)
				{
					data[r-1][c]=sheet.getRow(r).getCell(c).getStringCellValue();
				}
			}
			workbook.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return data;
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
