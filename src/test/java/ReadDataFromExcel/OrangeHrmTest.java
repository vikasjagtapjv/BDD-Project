package ReadDataFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHrmTest extends BaseClass {
	
	//WebDriver driver;
	@Test(dataProvider="InputData")
	public void orangeHrmTest(String name,String pass) {
		//driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement element=driver.findElement(By.xpath("//input[@name='username']"));
		element.sendKeys(name);
		WebElement element01=driver.findElement(By.xpath("//input[@name='password']"));
		element01.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	@DataProvider(name="InputData")
	public Object[][]fetchData()
	{
		String filename="C:\\Users\\Vikas\\Desktop\\testGoogle.xlsx";
		Object [][] fileData=getInputData(filename,"Sheet3");
		return fileData;
	}
	public String[][] getInputData(String fileName,String sheetName)
	{
		String [][] data02=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			XSSFSheet sheet=workbook.getSheet(sheetName);
			int row =sheet.getLastRowNum()+1;
			int cell=sheet.getRow(0).getLastCellNum();
			data02= new String[row-1][cell];
			for(int r=1;r<row;r++) {
				for(int c=0;c<cell;c++) {
					data02[r-1][c]=sheet.getRow(r).getCell(c).getStringCellValue();
				}
			}
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data02;
	}
	

}
