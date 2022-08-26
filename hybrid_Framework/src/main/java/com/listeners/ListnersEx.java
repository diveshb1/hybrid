package com.listeners;

import javax.naming.spi.DirStateFactory.Result;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utility.ReportUtils;
import com.Utility.ScreenShotUtils;
import com.aventstack.extentreports.Status;

public class ListnersEx implements ITestListener {

	public void onTestStart(ITestResult result) {
		//initialize ExtentTest
		ReportUtils.test=ReportUtils.report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
	ReportUtils.test.log(Status.PASS, "Test Case Passed With name :"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		ReportUtils.test.log(Status.FAIL, "Test Case Failed With Name :"+result.getName());
		
			 String path = null;
			try {
				path = ScreenShotUtils.GetScreenShot(result.getName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		ReportUtils.test.addScreenCaptureFromPath(path);
		
	}

	public void onTestSkipped(ITestResult result) {
	ReportUtils.test.log(Status.SKIP, "Test Case skipped with name :"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		//initalize report
      ReportUtils.reoprtInit();
		
	}

	public void onFinish(ITestContext context) {
		//It is use for save the report
		ReportUtils.report.flush();
		
	}

}
