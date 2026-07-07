package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLoanPage extends CommonLocators {

    WebDriver driver;

    public HomeLoanPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='home-loan']/a")
    WebElement homeLoanMenu;

    // Textboxes

    /*@FindBy(id = "loanamount")
    WebElement loanAmount;

    @FindBy(id = "loaninterest")
    WebElement interestRate;

    @FindBy(id = "loanterm")
    WebElement loanTenure;*/

    // EMI Result




    @FindBy(xpath = "//table")
    WebElement repaymentTable;





    public void navigateToHomeLoan() {

        homeLoanMenu.click();
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



    public String getLoanAmount(){
        return loanAmount.getAttribute("value");
    }

    public String getInterestRate(){
        return interestRate.getAttribute("value");
    }

    public String getLoanTenure(){
        return loanTenure.getAttribute("value");
    }


    public void scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");
    }

    public boolean tableisVisible(){

        return repaymentTable.isDisplayed();

    }






}
