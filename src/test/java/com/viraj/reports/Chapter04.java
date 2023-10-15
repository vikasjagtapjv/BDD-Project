package com.viraj.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Chapter04 {
	public static void main(String[]args) 
	{
		ExtentReports extentReports =new ExtentReports();
		File file=new File("report.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(file);
		extentReports.attachReporter(sparkReporter);
		extentReports
		.createTest("test01")
		.log(Status.INFO,"info")
		.log(Status.INFO,"<b>info01</b>")
		.log(Status.INFO,"<i><b>info 02</b></i>");
		
		String xmldata="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>\r\n";
		String Jsondata="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
//		extentReports
//		.createTest("XML Based Test")
//		.log(Status.INFO,xmldata );
//		
//		extentReports
//		.createTest("JSON Based Test")
//		.log(Status.INFO, Jsondata);
//				
		extentReports
		.createTest("XML BASED TEST")
		.info(MarkupHelper.createCodeBlock(xmldata,CodeLanguage.XML));
		
		extentReports
		.createTest("JSON BASED TEST")
		.log(Status.INFO,MarkupHelper.createCodeBlock(Jsondata,CodeLanguage.JSON));
		
		//collection
		List<String>listData=new ArrayList<String>();
		listData.add("vikas");
		listData.add("Ganesh");
		listData.add("Jagtap");
		
		Map<Integer,String>mapData=new HashMap<Integer,String>();
		mapData.put(100, "Vikas");
		mapData.put(101, "Ganesh");
		mapData.put(102, "Jagtap");
		
		Set<Integer>setData=mapData.keySet();
		
		
		extentReports
		.createTest("CREATE list data")
		.log(Status.INFO,MarkupHelper.createOrderedList(listData))
		.info(MarkupHelper.createUnorderedList(listData));
		
		extentReports
		.createTest("HASHMAP Data created")
		.log(Status.INFO,MarkupHelper.createOrderedList(mapData))
		.info(MarkupHelper.createUnorderedList(mapData));
		
		extentReports
		.createTest("Set based data")
		.log(Status.INFO,MarkupHelper.createOrderedList(setData))
		.info(MarkupHelper.createUnorderedList(setData));
		
		//Hightlight Any Message
		extentReports
		.createTest("Highlight log test")
		.info("This is not a highlighted message")
		.info(MarkupHelper.createLabel("This is highlighted message",ExtentColor.RED));
		
		//Exceptions
		try {
			int i=5/0;
		}
		catch(Exception e)
		{
			extentReports
			.createTest("Exception test")
			.fail(e);
		}
		Throwable t=new RuntimeException("This is a custom exception ");
		extentReports
		.createTest("Exception TEST 02")
		.log(Status.FAIL,t);
		
		extentReports
		.createTest("exception Test 03")
		.log(Status.FAIL,t);
		
		
		extentReports.flush();
		
		try {
			Desktop.getDesktop().browse(new File("report.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
