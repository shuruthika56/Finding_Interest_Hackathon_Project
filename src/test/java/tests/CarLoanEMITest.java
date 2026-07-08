package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CarLoanEMIPage;
import utilities.ConfigReader;
import utilities.ExtentReport;

import java.time.Duration;

public class CarLoanEMITest extends BaseClass {

    ExtentReport erm;

    @BeforeTest
    public void startReporter()
    {
        erm = new ExtentReport();
        erm.createTest("Test flow for car loan");
    }
    @Test(priority = 1)
    public void verifyNavigationToCarLoan() {

        CarLoanEMIPage page =
                new CarLoanEMIPage(getDriver());

        page.navigateToCarLoan();
        System.out.println("Successfully Launched");
        Assert.assertTrue(
                page.verifyInputFields(),
                "Input fields not displayed");
        erm.logPass("Successfully navigated to Car loan page");
    }



    @Test(priority = 2)
    public void verifyCarEMICalculation() {

        CarLoanEMIPage page = new CarLoanEMIPage(getDriver());
        ConfigReader rc = new ConfigReader();

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        page.enterLoanAmount(rc.getLoanAmount());

        page.enterInterest(rc.getInterestRate());

        page.enterTenure(rc.getLoanTenure());

        String emi = page.getEmiValue();

        System.out.println("EMI : " + emi);

        Assert.assertFalse(
                emi.isEmpty(),
                "EMI is not displayed");
        erm.logPass("EMI is calculated successfully");
    }

    @Test(priority = 3)
    public void verifyFirstMonthInterest() throws Exception{

        CarLoanEMIPage page = new CarLoanEMIPage(getDriver());

        page.scrollDown();
        page.clickTable();
        String interest =
                page.getFirstMonthInterest();
        System.out.println("First Month Interest : " + interest);

        Assert.assertFalse(
                interest.isEmpty(),
                "Interest amount is not displayed");
        erm.logPass("Monthly Interest is calculated successfully");
    }

    @Test(priority = 4)
    public void verifyFirstMonthPrincipal() {

        CarLoanEMIPage page = new CarLoanEMIPage(getDriver());

        page.scrollDown();

        page.clickTable();

        String principal =
                page.getFirstMonthPrincipal();

        System.out.println(
                "First Month Principal : "
                        + principal);

        Assert.assertFalse(
                principal.isEmpty(),
                "Principal amount not displayed");
        erm.logPass("Monthly Principle amount is calculated successfully");
    }

    @AfterTest
    public void flushReport() {
        erm.flushReports();
    }
}