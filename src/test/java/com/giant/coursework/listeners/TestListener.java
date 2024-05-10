package com.giant.coursework.listeners;

import com.giant.coursework.utils.Driver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import java.io.IOException;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Driver.getDriver().close();
    }

//    @Override
//    public void onTestFailure(ITestResult iTestResult) {
//        //get screenshot
//        try {
//            Screenshot.getScreenshot(iTestResult.getName());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Driver.getDriver().quit();
    }
}

