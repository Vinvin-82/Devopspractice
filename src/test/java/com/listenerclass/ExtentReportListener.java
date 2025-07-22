package com.listenerclass;


import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.testng.IAlterSuiteListener;
import org.testng.IExecutionListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestListener, ISuiteListener {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    
    

    @Override
    public void onStart(ISuite suite) {
    	String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
    	ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Project", "Ecommerce Domain");
        extent.setSystemInfo("Tester", "Vinaya Bai");
        System.out.println("Extent Report initialization started");
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ISuite suite) {
    	  System.out.println("✅ Flushing report...");
    	    extent.flush();
    	    System.out.println("✅ Report flushed.");    }

}

