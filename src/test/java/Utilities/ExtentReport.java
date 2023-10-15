package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	WebDriver driver;
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public ExtentReport(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	public void generateExtentReport()
	{
		htmlReporter=new ExtentSparkReporter("EXtentListenerReport.html");
		reports= new ExtentReports();
		reports.attachReporter(htmlReporter);
		
		
		//Set configuration
		reports.setSystemInfo("Machine","TestPc01");
		reports.setSystemInfo("User","Vikas Jagtap");
		reports.setSystemInfo("Operating System", "Windows 11");
		reports.setSystemInfo("Browser", "Chrome");
		reports.setSystemInfo("Host","QA Engineer");
		
		//Look And feel
		htmlReporter.config().setDocumentTitle("Extent Report for OrangeHrmApplication");
		htmlReporter.config().setReportName("This is for client review purpose");
		htmlReporter.config().setTheme(Theme.DARK);

		
		
	}
	

	
	public void onStart(ITestContext result)
	{
		generateExtentReport();
		System.out.println("On Start Method Invoked::::");
	}
	
	public void onFinish(ITestContext result)
	{
		System.out.println("On finish Method Invoked::::");
		reports.flush();
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("On Test Start Method invoked::::"+ result.getName());
		
	}
	public void onTestSuccess(ITestResult result) {
		System.out.println("On test Success Method invoked:::"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper
				.createLabel("Name of pass test is"+result.getName(),ExtentColor.GREEN ));
		
		
	}
	public void onTestFailure(ITestResult result)
	{
		System.out.println("on test  failure method invoked::: "+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper
				.createLabel("name of fail test is :"+result.getName(),ExtentColor.RED));
		
		
	}
	public void onTestSkipped(ITestResult result) {
		System.out.println("On test Skipped method Invoked:::"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of skipped test is :"+result.getName(),ExtentColor.YELLOW));
	}

	

}
