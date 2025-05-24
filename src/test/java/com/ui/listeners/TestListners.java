package com.ui.listeners;

import java.util.Arrays;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.ExtentReporterUtlity;
import com.utility.LoggerUtlity;
import com.utility.ReusableUtility;

public class TestListners implements ITestListener {

	Logger logger = LoggerUtlity.getLogger(this.getClass());

	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;

	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtlity.createExtentTest(result.getMethod().getMethodName());

	}

	public void onTestSuccess(ITestResult result) {
		logger.info(result.getMethod().getMethodName() + " " + "PASSED");
		ExtentReporterUtlity.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
	}

	public void onTestFailure(ITestResult result) {
		logger.error(result.getMethod().getMethodName() + " " + "FAILED");
		logger.error(result.getThrowable().getMessage());
		ExtentReporterUtlity.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReporterUtlity.getTest().log(Status.FAIL, result.getThrowable().getMessage() + " " + "FAILED");
		Object testclass = result.getInstance();
		ReusableUtility reusableUtility = ((TestBase)testclass).getInstance();
		logger.info("Capturing Screenshot for the failed tests");
		String screenshotPath = reusableUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching the Screenshot to the HTML File");
		ExtentReporterUtlity.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSkipped(ITestResult result) {
		logger.warn(result.getMethod().getMethodName() + " " + "SKIPPED");
		ExtentReporterUtlity.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " " + "SKIPPED");
	}

	public void onStart(ITestContext context) {
		logger.info("Test suit Started");
		ExtentReporterUtlity.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {
		logger.info("Test suit Completed");
		ExtentReporterUtlity.flushReport();

	}

}
