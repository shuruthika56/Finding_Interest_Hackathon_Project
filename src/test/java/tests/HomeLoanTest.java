package tests;

import base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLoanPage;
import utilities.ExcelUtility;
import utilities.ExtentReport;
import utilities.ConfigReader;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import listeners.TestListener;


public class HomeLoanTest extends BaseClass {

    ExtentReport erm;

    //WebDriver driver;

   // HomeLoanPage page;

    @BeforeTest
    public void startReporter()
    {
        erm = new ExtentReport();
        erm.createTest("Test flow for Home loan");

    }

    @Test(priority = 1)
    public void verifyNavigationToCarLoan() {
        HomeLoanPage page  = new HomeLoanPage(driver);
       //page.navigateToHomeLoan();
        System.out.println("Successfully Launched");
        Assert.assertTrue(
                page.verifyInputFields(),
                "Input fields not displayed");
        erm.logPass("Successfully navigated to Car loan page");
    }

    @Test(priority = 2)
    public void verifyEnterData(){

        HomeLoanPage page  = new HomeLoanPage(driver);

        ConfigReader cr = new ConfigReader();

        page.enterLoanAmount(cr.getLoanAmount());
        page.enterInterest(cr.getInterestRate());
        page.enterTenure(cr.getLoanTenure());


        Assert.assertEquals(
                page.getLoanAmount().replace(",", ""),
                cr.getLoanAmount(),
                "Loan amount mismatch");
        erm.logPass("Loan amount successfully validated");

        Assert.assertEquals(
                page.getInterestRate(),
                cr.getInterestRate(),
                "Interest rate mismatch");
        erm.logPass("Interest rate successfully validated");

        Assert.assertEquals(
                page.getLoanTenure(),
                cr.getLoanTenure(),
                "Loan tenure mismatch");

        erm.logPass("Loan Tenure successfully validated");

    }

    @Test(priority = 3)
    public void verifyRepaymentTableDisplayed(){
        HomeLoanPage page  = new HomeLoanPage(driver);

        page.scrollDown();

        Assert.assertEquals(page.tableisVisible(),true,"Table is not displayed");

        erm.logPass("Repayment table is displayed successfully");


    }

    @Test(priority = 4)
    public void verifyDataExcel(){

        HomeLoanPage page  = new HomeLoanPage(driver);

        page.scrollDown();
        ExcelUtility.writeHomeLoanTableToExcel(
                driver,
                "Home_Loan.xlsx",
                "Home_Loan");

        erm.logPass("Yearly Table Data is successfully written to Excel");




    }

    @AfterTest
    public void flushReport() {

        erm.flushReports();
    }

}
