package tests;

import base.BaseClass;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomeLoanPage;
import utilities.ExcelUtility;
import utilities.ExtentReport;
import utilities.ConfigReader;



public class HomeLoanTest extends BaseClass {

    ExtentReport erm;


    @BeforeTest
    public void startReporter()
    {
        erm = new ExtentReport();
        erm.createTest("Test flow for Home loan");

    }

    @Test(priority = 1)
    public void verifyNavigationToHomeLoan() {
        HomeLoanPage page  = new HomeLoanPage(getDriver());
        //page.navigateToHomeLoan();
        System.out.println("Successfully Launched");
        Assert.assertTrue(
                page.verifyInputFields(),
                "Input fields not displayed");
        erm.logPass("Successfully navigated to Car loan page");
    }

    @Test(priority = 2)
    public void verifyEnterData(){

        HomeLoanPage page  = new HomeLoanPage(getDriver());

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
        HomeLoanPage page  = new HomeLoanPage(getDriver());

        page.scrollDown();

        Assert.assertEquals(page.tableisVisible(),true,"Table is not displayed");

        erm.logPass("Repayment table is displayed successfully");


    }

    @Test(priority = 4)
    public void verifyDataExcel(){

        HomeLoanPage page  = new HomeLoanPage(getDriver());

        page.scrollDown();
        ExcelUtility.writeHomeLoanTableToExcel(
                getDriver(),
                "Home_Loan.xlsx",
                "Home_Loan");

        erm.logPass("Yearly Table Data is successfully written to Excel");




    }

    @AfterTest
    public void flushReport() {

        erm.flushReports();
    }

}
