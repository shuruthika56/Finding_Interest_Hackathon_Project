package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class CarLoanEMIPage  extends CommonLocators{

   WebDriver driver;

    public CarLoanEMIPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Menu

    @FindBy(linkText = "Car Loan")
    WebElement carLoanMenu;

    // Textboxes

   /* @FindBy(id = "loanamount")
    WebElement loanAmount;

    @FindBy(id = "loaninterest")
    WebElement interestRate;

    @FindBy(id = "loanterm")
    WebElement loanTenure;*/

    // EMI Result

    @FindBy(xpath = "//*[@id='emiamount']/p/span")
    WebElement emiAmount;


    @FindBy(xpath = "//table")
    WebElement repaymentTable;


    @FindBy(xpath="//*[@id='year2026']")
    WebElement btn;


    @FindBy(xpath = "//*[@id='monthyear2026']/td/div/table/tbody/tr[1]/td[3]")
    WebElement firstMonthInterest;

    // Month 1 Principal

    @FindBy(xpath = "//*[@id='monthyear2026']/td/div/table/tbody/tr[1]/td[2]")
    WebElement firstMonthPrincipal;


    public void navigateToCarLoan() {

        carLoanMenu.click();
    }

    public boolean verifyInputFields() {

        return loanAmount.isDisplayed()
                && interestRate.isDisplayed()
                && loanTenure.isDisplayed();
    }

    public void enterLoanAmount(String amount) {

        loanAmount.sendKeys(Keys.CONTROL + "a");
        //loanAmount.sendKeys(Keys.BACK_SPACE);
        loanAmount.sendKeys(amount);
    }

    public void enterInterest(String interest) {

        interestRate.sendKeys(Keys.CONTROL + "a");
        //interestRate.sendKeys(Keys.BACK_SPACE);
        interestRate.sendKeys(interest);
    }

    public void enterTenure(String tenure) {

        loanTenure.sendKeys(Keys.CONTROL + "a");
        //loanTenure.sendKeys(Keys.BACK_SPACE);
        loanTenure.sendKeys(tenure);
    }




    public void scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
    }

    public void clickTable(){
        btn.click();

        try {
            Thread.sleep(5000);
        } catch(Exception e) {

        }

    }


    public String getEmiValue() {
        return emiAmount.getText();
    }

    public String getFirstMonthInterest() {


        return firstMonthInterest.getAttribute("innerText");

    }

    public String getFirstMonthPrincipal() {
        return firstMonthPrincipal.getText();
    }

}