package ExtentReportDemo;

import org.testng.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.*;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass implements ITestListener{
	
	ExtentSparkReporter HtmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public void configureReport() {
		HtmlReporter=new ExtentSparkReporter("ExtentListenerReport.html");
		reports=new ExtentReports();
		reports.attachReporter(HtmlReporter);
		
		//We can add the Environmental details 
		reports.setSystemInfo("Machine ", "TestPc01");
		reports.setSystemInfo("Operating System","windows 11");
		reports.setSystemInfo("Browser","Chrome");
		reports.setSystemInfo("Host", "Test Engineer");
		reports.setSystemInfo("UserName","Vikas");
		
		//Configuration to change look and feel of report
		HtmlReporter.config().setDocumentTitle("Extent Listener Report Demo.");
		HtmlReporter.config().setReportName("This is my first Extent Report");
		HtmlReporter.config().setTheme(Theme.DARK);
		
		
	}
	
	public void onStart(ITestContext result)
	{
		configureReport();
		System.out.println("On Start Method Invoked::::::");
	}
	
	public void onFinish(ITestContext result)
	{
		System.out.println("On finish Method Invoked:::::::");
		reports.flush();
	}
	public void onTestStart(ITestResult result)
	{
		System.out.println("Name of the test method  Started:"+result.getName());
	}
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("Name of the test method  passed:"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper
				.createLabel("Name of pass Test case is :"+result.getName(),ExtentColor.GREEN));
	}
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("Name of the test method  skipped:"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper.createLabel("Name of the skipped test case is :"+result
						.getName(),ExtentColor.YELLOW));
	}
	public void onTestFailure(ITestResult result)
	
	{
		
		
		System.out.println("Name of the test method  Failed:"+result.getName());
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper.createLabel("Name of the failed test case is :"+result
				.getName(), ExtentColor.RED));
	}

}
