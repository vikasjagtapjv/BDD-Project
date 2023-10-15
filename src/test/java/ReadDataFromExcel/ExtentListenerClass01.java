package ReadDataFromExcel;

import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentListenerClass01 implements ITestListener {
	ExtentSparkReporter htmlReporter;
	ExtentReports reports;
	ExtentTest test;
	public void configProperties() {
		
		 htmlReporter=new ExtentSparkReporter("EXtentListenerReport");
		 reports=new ExtentReports();
		 reports.attachReporter(htmlReporter);
		
		
		
		
		reports.setSystemInfo("Machine","Test 01");
		reports.setSystemInfo("OS", "Windows 11");
		reports.setSystemInfo("Browser","Chrome ");
		reports.setSystemInfo("HOSt", "Test Engineer");
		reports.setSystemInfo("UserName", "Vikas Jagtap");
		
		//setUp of Look And feel
		//Date date=new Date();
		
		htmlReporter.config().setDocumentTitle("Extent Report");
		htmlReporter.config().setReportName("Report ");
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onStart(ITestContext result)
	{
		configProperties();
		System.out.println("It Stat only once ");
	}
	public void onTestSuccess(ITestResult result)
	{
		test=reports.createTest(result.getName());
		test.log(Status.PASS,MarkupHelper
				.createLabel("Name of Test Case is "+result.getName(),ExtentColor.GREEN));
		
	}
	public void onTestFailure(ITestResult result)
	{
		test=reports.createTest(result.getName());
		test.log(Status.FAIL,MarkupHelper
				.createLabel(" Test Method Name is "+result.getName(),ExtentColor.RED));
	}
	public void onTestSkipped(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.SKIP,MarkupHelper
				.createLabel("Test Method Name is "+result.getName(),ExtentColor.YELLOW));
	}
	public void onFinish(ITestContext result)
	{
		System.out.println("This method is invoked After Completion of each method Execution");
		reports.flush();
	}

}
