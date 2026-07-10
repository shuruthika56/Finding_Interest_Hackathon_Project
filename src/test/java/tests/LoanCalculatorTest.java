package tests;

import base.BaseClass;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoanCalculatorPage;
import utilities.ConfigReader;
import utilities.ExtentReport;

public class LoanCalculatorTest extends BaseClass {

    ExtentReport erm;
    @BeforeTest
    public void startReporter()
    {
        erm = new ExtentReport();
        erm.createTest("Test flow for Loan Calculator");

    }

    @Test(priority = 1)
    public void verifyNavigationToLoanCalculator() {

        LoanCalculatorPage page =
                new LoanCalculatorPage(getDriver());

        // page.clickMenu();
        page.clickloanWidgets();
        page.clickLoancal();
        System.out.println("Successfully Launched");
        Assert.assertTrue(
                page.verifyInputFields(),
                "Input fields not displayed");
    }

    @Test(priority = 2)
    public void verifyLoanAmountTextBoxAndSliderEMI() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedLoanAmount =
                rc.getLoanAmount();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterLoanAmount(expectedLoanAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getLoanAmountValue(),
                expectedLoanAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Amount:Value entered Successfully in textbox of EMI Calculator");



//        Thread.sleep((1000));

        lp.bodyClick();

        // Store initial slider position
        int beforeSliderMove =
                lp.getSliderLocation();

//        Thread.sleep((1000));

        //lp.scrollDown();

        // Move slider
        lp.moveLoanAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getSliderLocation();

//        Thread.sleep((1000));

        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Amount:Slider position successfully changed in  EMI Calculator");


        // erm.logPass("");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getLoanAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedLoanAmount,
                "Textbox value not updated after slider movement"
        );

//        Thread.sleep((1000));

        System.out.println("Updated Loan Amount : "
                + updatedValue);
        erm.logPass("Loan Amount:Value changed in slider is correctly displayed in Textbox of EMI Calculator");



    }

    @Test(priority = 3)
    public void verifyInterestAmountTextBoxAndSliderEMI() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedInterestAmount =
                rc.getInterestRate();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterInterestAmount(expectedInterestAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getInterestAmountValue(),
                expectedInterestAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Interest:Value entered Successfully in textbox of EMI Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getInterestSliderLocation();

//        Thread.sleep((1000));

        // lp.scrollDown();

        // Move slider
        lp.moveInterestAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getInterestSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Interest:Slider position successfully changed in  EMI Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getInterestAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedInterestAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Interest:Value changed in slider is correctly displayed in Textbox of EMI Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Interest Amount : "
                + updatedValue);


    }

    @Test(priority = 4)
    public void verifyTenureAmountTextBoxAndSliderEMI() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedTenureAmount =
                rc.getLoanTenure();

        //lp.scrollDown();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterTenureAmount(expectedTenureAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getTenureAmountValue(),
                expectedTenureAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Tenure:Value entered Successfully in textbox of EMI Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.moveTenureAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Tenure:Slider position successfully changed in  EMI Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getTenureAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedTenureAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Tenure:Value changed in slider is correctly displayed in Textbox of EMI Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }

    @Test(priority = 5)
    public void verifyTenureAmountTextBoxAndSliderEMIMonth() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());
        lp.clickMonth();

        String expectedTenureAmount =
                rc.getMonth();

        //lp.scrollDown();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterTenureAmount(expectedTenureAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getTenureAmountValue(),
                expectedTenureAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Tenure:Value entered Successfully in textbox of EMI Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.moveTenureAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Tenure:Slider position successfully changed in  EMI Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getTenureAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedTenureAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Tenure:Value changed in slider is correctly displayed in Textbox of EMI Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }

    @Test(priority = 6)
    public void verifyFeesAmountTextBoxAndSliderEMI() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedFeesAmount =
                rc.getFeesCharges();

        //lp.scrollDown();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterfeesAmount(expectedFeesAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getfeesAmountValue(),
                expectedFeesAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Fees:Value entered Successfully in textbox of EMI Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getfeesSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.movefeesAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getfeesSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Fees:Slider position successfully changed in  EMI Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getfeesAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedFeesAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Fees:Value changed in slider is correctly displayed in Textbox of EMI Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }

    @Test(priority = 7)
    public void verifyNavigationToLoanAmountCalculator() {

        LoanCalculatorPage page =
                new LoanCalculatorPage(getDriver());

        page.clickLoanAmount();

        System.out.println(
                "Navigated Successfully to Loan Amount Calculator");


    }

    @Test(priority = 8)
    public void verifyLoanAmountTextBoxAndSliderLoanCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedEMIAmount =
                rc.getEmi();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterEMIAmount(expectedEMIAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getEMIAmountValue(),
                expectedEMIAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Amount:Value entered Successfully in textbox of Loan Calculator");



//        Thread.sleep((1000));

        lp.bodyClick();

        // Store initial slider position
        int beforeSliderMove =
                lp.getEMISliderLocation();

//        Thread.sleep((1000));

        //lp.scrollDown();

        // Move slider
        lp.moveEMIAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getEMISliderLocation();

//        Thread.sleep((1000));

        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Amount:Slider position successfully changed in  Loan Calculator");




//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getEMIAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedEMIAmount,
                "Textbox value not updated after slider movement"
        );

//        Thread.sleep((1000));

        System.out.println("Updated EMI Amount : "
                + updatedValue);
        erm.logPass("Loan Amount:Value changed in slider is correctly displayed in Textbox of Loan Calculator");



    }

    @Test(priority = 9)
    public void verifyInterestAmountTextBoxAndSliderLoanCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedInterestAmount =
                rc.getInterestRate();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterInterestAmount(expectedInterestAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getInterestAmountValue(),
                expectedInterestAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Interest:Value entered Successfully in textbox of Loan Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getInterestSliderLocation();

//        Thread.sleep((1000));

        //lp.scrollDown();

        // Move slider
        lp.moveInterestAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getInterestSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Interest:Slider position successfully changed in  Loan Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getInterestAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedInterestAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Interest:Value changed in slider is correctly displayed in Textbox of Loan Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Interest Amount : "
                + updatedValue);


    }

    @Test(priority = 10)
    public void verifyTenureAmountTextBoxAndSliderLoanCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedTenureAmount =
                rc.getLoanTenure();

        //lp.scrollDown();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterTenureAmount(expectedTenureAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getTenureAmountValue(),
                expectedTenureAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Tenure:Value entered Successfully in textbox of Loan Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.moveTenureAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Tenure:Slider position successfully changed in  Loan Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getTenureAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedTenureAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Tenure:Value changed in slider is correctly displayed in Textbox of Loan Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }

    @Test(priority = 11)
    public void verifyTenureAmountTextBoxAndSliderLoanCalMonth() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        lp.clickMonth();

        String expectedTenureAmount =
                rc.getMonth();

        //lp.scrollDown();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterTenureAmount(expectedTenureAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getTenureAmountValue(),
                expectedTenureAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Tenure Month:Value entered Successfully in textbox of Loan Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.moveTenureAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getTenureSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Tenure Month:Slider position successfully changed in  Loan Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getTenureAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedTenureAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Tenure Month:Value changed in slider is correctly displayed in Textbox of Loan Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }

    @Test(priority = 12)
    public void verifyFeesAmountTextBoxAndSliderEMILoanCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedFeesAmount =
                rc.getFeesCharges();

        //lp.scrollDown();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterfeesAmount(expectedFeesAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getfeesAmountValue(),
                expectedFeesAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Fees:Value entered Successfully in textbox of Loan Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getfeesSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.movefeesAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getfeesSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Fees:Slider position successfully changed in  Loan Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getfeesAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedFeesAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Fees:Value changed in slider is correctly displayed in Textbox of Loan Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }

    @Test(priority = 13)
    public void verifyNavigationToLoanTenureCalculator() {

        LoanCalculatorPage page =
                new LoanCalculatorPage(getDriver());

        page.clickTenureCal();

        System.out.println(
                "Navigated Successfully to Loan Tenure Calculator");


    }

    @Test(priority = 14)
    public void verifyLoanAmountTextBoxAndSliderLoanTenure() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedLoanAmount =
                rc.getLoanAmount();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterLoanAmount(expectedLoanAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getLoanAmountValue(),
                expectedLoanAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Amount:Value entered Successfully in textbox of Loan Tenure Calculator");



//        Thread.sleep((1000));

        lp.bodyClick();

        // Store initial slider position
        int beforeSliderMove =
                lp.getSliderLocation();

//        Thread.sleep((1000));

        //lp.scrollDown();

        // Move slider
        lp.moveLoanAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getSliderLocation();

//        Thread.sleep((1000));

        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Amount:Slider position successfully changed in  Loan Tenure Calculator");


        erm.logPass("");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getLoanAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedLoanAmount,
                "Textbox value not updated after slider movement"
        );

//        Thread.sleep((1000));

        System.out.println("Updated Loan Amount : "
                + updatedValue);
        erm.logPass("Loan Amount:Value changed in slider is correctly displayed in Textbox of Loan Tenure Calculator");



    }

    @Test(priority = 15)
    public void verifyLoanAmountTextBoxAndSliderLoanTentureCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedEMIAmount =
                rc.getEmi();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterEMIAmount(expectedEMIAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getEMIAmountValue(),
                expectedEMIAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Amount:Value entered Successfully in textbox of Loan Tenure Calculator");



//        Thread.sleep((1000));

        lp.bodyClick();

        // Store initial slider position
        int beforeSliderMove =
                lp.getEMISliderLocation();

//        Thread.sleep((1000));

        //lp.scrollDown();

        // Move slider
        lp.moveEMIAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getEMISliderLocation();

//        Thread.sleep((1000));

        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Amount:Slider position successfully changed in  Loan Tenure Calculator");


        erm.logPass("");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getEMIAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedEMIAmount,
                "Textbox value not updated after slider movement"
        );

//        Thread.sleep((1000));

        System.out.println("Updated EMI Amount : "
                + updatedValue);
        erm.logPass("Loan Amount:Value changed in slider is correctly displayed in Textbox of Loan Tenure Calculator");



    }


    @Test(priority = 16)
    public void verifyInterestAmountTextBoxAndSliderLoanTenureCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedInterestAmount =
                rc.getInterestRate();

//        Thread.sleep((1000));

        // Enter value from config
        lp.enterInterestAmount(expectedInterestAmount);
//        Thread.sleep((1000));

        // Validate textbox value
        Assert.assertEquals(
                lp.getInterestAmountValue(),
                expectedInterestAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Interest:Value entered Successfully in textbox of Loan Tenure Calculator");
        lp.bodyClick();

//        Thread.sleep((1000));

        // Store initial slider position
        int beforeSliderMove =
                lp.getInterestSliderLocation();

//        Thread.sleep((1000));

        //lp.scrollDown();

        // Move slider
        lp.moveInterestAmountSlider();

//        Thread.sleep((1000));

        // Store slider position after move
        int afterSliderMove =
                lp.getInterestSliderLocation();

//        Thread.sleep((1000));


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Interest:Slider position successfully changed in  Loan Tenure Calculator");

//        Thread.sleep((1000));

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getInterestAmountValue();

//        Thread.sleep((1000));

        Assert.assertNotEquals(
                updatedValue,
                expectedInterestAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Interest:Value changed in slider is correctly displayed in Textbox of Loan Tenure Calculator");


//        Thread.sleep((1000));

        System.out.println("Updated Interest Amount : "
                + updatedValue);


    }


    @Test(priority = 17)
    public void verifyFeesAmountTextBoxAndSliderEMILoanTenureCal() throws Exception {

        ConfigReader rc = new ConfigReader();

        LoanCalculatorPage lp =
                new LoanCalculatorPage(getDriver());

        String expectedFeesAmount =
                rc.getFeesCharges();

        //lp.scrollDown();

        // Thread.sleep(1000);

        // Enter value from config
        lp.enterfeesAmount(expectedFeesAmount);
        //Thread.sleep(1000);

        // Validate textbox value
        Assert.assertEquals(
                lp.getfeesAmountValue(),
                expectedFeesAmount,
                "Textbox value mismatch"
        );
        erm.logPass("Loan Fees:Value entered Successfully in textbox of Loan Tenure Calculator");
        lp.bodyClick();

        //Thread.sleep(1000);

        // Store initial slider position
        int beforeSliderMove =
                lp.getfeesSliderLocation();

//        Thread.sleep((1000));



        // Move slider
        lp.movefeesAmountSlider();

        //Thread.sleep(1000);

        // Store slider position after move
        int afterSliderMove =
                lp.getfeesSliderLocation();

        //Thread.sleep(1000);


        // Verify slider actually moved
        Assert.assertNotEquals(
                beforeSliderMove,
                afterSliderMove,
                "Slider position not changed"
        );
        erm.logPass("Loan Fees:Slider position successfully changed in  Loan Tenure Calculator");

        //Thread.sleep(1000);

        // Verify textbox value changed after slider movement
        String updatedValue =
                lp.getfeesAmountValue().replace(",", "");

        //Thread.sleep(1000);

        Assert.assertNotEquals(
                updatedValue,
                expectedFeesAmount,
                "Textbox value not updated after slider movement"
        );
        erm.logPass("Loan Fees:Value changed in slider is correctly displayed in Textbox of Loan Tenure Calculator");


        //Thread.sleep(1000);

        System.out.println("Updated Tenure Amount : "
                + updatedValue);


    }
    @AfterTest
    public void flushReport() {

        erm.flushReports();
    }

}
