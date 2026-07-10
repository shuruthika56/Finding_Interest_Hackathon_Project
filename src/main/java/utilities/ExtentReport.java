package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {

    public ExtentSparkReporter sparkReporter;
    public ExtentReports extentreport;
    public static ExtentTest testLogger;
    WebDriver driver;

    public ExtentReport() {
        String folderName = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
        String reportFolderPath = System.getProperty("user.dir") + "\\reports\\";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFolderPath + "\\FindingInterestTestReport_"+  folderName+".html");

        sparkReporter.config().setDocumentTitle("Automation Extent Report");
        sparkReporter.config().setReportName("Finding Interest Test Report");
        sparkReporter.config().setTheme(Theme.STANDARD);
        sparkReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm:ss a '('zzz')'");
        extentreport = new ExtentReports();
        extentreport.attachReporter(sparkReporter);

    }

    public void createTest(String testName) {

        testLogger = extentreport.createTest(testName);
    }

    public void logPass(String message) {

        testLogger.pass(message);
    }

    public void flushReports() {

        extentreport.flush();
    }

}
