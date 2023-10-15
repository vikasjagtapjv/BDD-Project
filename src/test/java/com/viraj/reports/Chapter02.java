package com.viraj.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter02 {
	public static void main(String[] args) 
	{


		ExtentReports extentReports=new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);

		extentReports.attachReporter(sparkReporter);
		ExtentTest test01=extentReports.createTest("Test 01");
		test01.pass("This is passed");
		ExtentTest test02=extentReports.createTest("Test 02");
		test02.fail("This is failed");
		ExtentTest test03=extentReports.createTest("Test 03");
		test03.skip("This is Skipped");
		ExtentTest test04=extentReports.createTest("Test 04");
		test04.log(Status.FAIL,"This is a failed test 04");
		// now we are using the method chaining
		extentReports.createTest("test 05").log(Status.PASS,"This is Passed test 05");
		extentReports.createTest("test 06").pass("This is passed test o6");
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("report.html").toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


