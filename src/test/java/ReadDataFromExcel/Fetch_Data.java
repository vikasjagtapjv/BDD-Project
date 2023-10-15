package ReadDataFromExcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Fetch_Data extends BaseClass{
	@Test(dataProvider="TestData")
	public void demo(String name,String pass)
    {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		WebElement element =driver.findElement(By.xpath("//input[@name='username']"));
		element.sendKeys(name);
		WebElement element01=driver.findElement(By.xpath("//input[@name='password']"));
		element01.sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
	}
	@DataProvider(name="TestData")
	public Object[][]getData() throws IOException 
	{
		String fN="E:\\PracticeExtentMaven\\src\\test\\java"
				+ "\\ReadDataFromExcel\\excelFile\\testGoogle.xlsx";
		Object[][]data=getInputData(fN,"Sheet3");
		return data;
	}
	
	public String[][]getInputData(String fileName,String sheetName) throws IOException
	{
		String[][]data01=null;
		try {
		FileInputStream fis=new FileInputStream(fileName);
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int row=sheet.getLastRowNum()+1;
		int cell=sheet.getRow(0).getLastCellNum();
		data01= new String[row-1][cell];
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
	

}
