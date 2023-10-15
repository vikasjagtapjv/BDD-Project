package com.viraj.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter03 {
	public static void main(String[]args)
	{
		ExtentReports extentReports=new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports.createTest("test01").pass("This is passed");
		extentReports
		
		//fail
		//skip
		//warning
		//pass
		//info
		.createTest("test 02")
		.log(Status.INFO,"information 02 is Passed")
		.log(Status.INFO,"Info 03")
		.log(Status.INFO,"Info 04")
		.log(Status.PASS,"pass")
		.log(Status.WARNING,"Warning")
		.log(Status.WARNING,"Warning")
		.log(Status.SKIP,"skip")
		.log(Status.SKIP,"skipped")
		.log(Status.INFO,"info")
		.log(Status.FAIL,"fail")
		.log(Status.PASS,"Pass");
		extentReports.flush();
		try {
			Desktop.getDesktop().browse(new File("report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
