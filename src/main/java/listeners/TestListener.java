package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseClass;
import utilities.ExtentReport;
import utilities.ScreenShotUtility;

public class TestListener implements ITestListener {


    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentReport.testLogger.pass(
                result.getName() + " Passed");
    }


    @Override
    public void onTestFailure(ITestResult result) {

        try {

            String screenshotPath =
                    ScreenShotUtility.screenShotTC(
                            BaseClass.driver,
                            result.getName());

            System.out.println(
                    "Screenshot captured : "
                            + screenshotPath);

            ExtentReport.testLogger.fail(result.getThrowable());

            ExtentReport.testLogger
                    .addScreenCaptureFromPath(screenshotPath);

        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
}