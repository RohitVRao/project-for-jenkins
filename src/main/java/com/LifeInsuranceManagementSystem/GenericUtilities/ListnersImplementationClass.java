package com.LifeInsuranceManagementSystem.GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnersImplementationClass implements ITestListener {
	  ExtentReports report;
	  ExtentTest test;
	

	public void onTestStart(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test = report.createTest(MethodName);
		Reporter.log(MethodName + "----script execution started----");
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.PASS,MethodName+" ---Passed");
		Reporter.log(MethodName+ "script executed successfully");
	}

	public void onTestFailure(ITestResult result)
	{
		String script = result.getMethod().getMethodName();
		String Failedscript = script+new JavaUtility().getSystemDateAndTimeFormat();
		EventFiringWebDriver edriver = new EventFiringWebDriver(BaseClass.sdriver);
		File src = edriver.getScreenshotAs(OutputType.FILE);
		File dst = new File("./Screenshot/"+ Failedscript + ".png");
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+ "---Skipped");
		test.log(Status.SKIP, result.getThrowable());
		Reporter.log(MethodName+ "script execution skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	public void onStart(ITestContext context) 
	{
		// execution starts
		// configure the report
	  ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report.html");
	  htmlreport.config().setDocumentTitle("Life Insurance Management System execution report");
	  htmlreport.config().setTheme(Theme.DARK);
	  htmlreport.config().setReportName("LIMS execution report");
	  
	  report = new ExtentReports();
	  report.attachReporter(htmlreport);
	  report.setSystemInfo("Base_Browser", "Chrome");
	  report.setSystemInfo("OS", "Windows");
	  report.setSystemInfo("Base_url", "http://rmgtestingserver/domain/Life_Insurance_Management_System/index.php");
	  report.setSystemInfo("ReporterName", "Rohit V Rao");
	  
	}
	

	public void onFinish(ITestContext context)
	{
		//Consolidate all the parameters and generate report
		report.flush();
	}
	
	
	

}
