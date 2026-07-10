package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoanCalculatorPage {

    WebDriver driver;

    public LoanCalculatorPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="/html/body/header/div/nav/button")
    WebElement menu;

    @FindBy(xpath="//*[@id='menu-item-dropdown-2696']")
    WebElement loanWidgets;

    @FindBy(xpath="//*[@id='menu-item-2423']/a")
    WebElement loanCal;

    @FindBy(xpath="//body")
    WebElement body;

    @FindBy(id="loanfees")
    WebElement loanFees;

    @FindBy(id="loanemi")
    WebElement emi;


    // Year / Month Radio Buttons

    @FindBy(id="loanyears")
    WebElement yearsBtn;

    @FindBy(xpath="//*[@id='ltermwrapper']//label[2]")   // //*[@id='ltermwrapper']/div[1]/div/div/div/div/div/label[2]
    WebElement monthsBtn;

    // Sliders

    @FindBy(xpath="//*[@id='loanamountslider']/span")
    WebElement loanAmountSlider;

    @FindBy(xpath="//*[@id='loaninterestslider']/span")
    WebElement interestSlider;


    @FindBy(xpath="//*[@id='loantermslider']/span")
    WebElement tenureSlider;

    @FindBy(xpath="//*[@id='loanfeesslider']/span")
    WebElement feesSlider;

    @FindBy(xpath="//*[@id='loanemislider']/span")
    WebElement emiSlider;

    @FindBy(id="loan-amount-calc")
    WebElement lAmountCal;

    @FindBy(xpath = "//*[contains(text(),'Loan Tenure ')]")
    WebElement lTenureCal;

    @FindBy(xpath = "//*[contains(text(),'Interest Rate ')]")
    WebElement lInterestCal;

    @FindBy(id = "loanamount")
    WebElement loanAmount;

    @FindBy(id = "loaninterest")
    WebElement interestRate;

    @FindBy(id = "loanterm")
    WebElement loanTenure;

    public void clickLoanAmount(){

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(
                lAmountCal));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                lAmountCal);


        wait.until(ExpectedConditions.elementToBeClickable(
                lAmountCal));

        js.executeScript(
                "arguments[0].click();",
                lAmountCal);


    }

    public void clickTenureCal(){
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(
                lTenureCal));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                lTenureCal);


        wait.until(ExpectedConditions.elementToBeClickable(
                lTenureCal));

        js.executeScript(
                "arguments[0].click();",
                lTenureCal);

    }

    public void clickInterestCal(){
        lInterestCal.click();
    }


    public void bodyClick(){
        body.click();
    }

    public void scrollDown() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1500)");
    }

    public void clickloanWidgets(){
        loanWidgets.click();
    }

    public void clickLoancal(){
        loanCal.click();
    }

    public boolean verifyInputFields() {

        return loanAmount.isDisplayed()
                && interestRate.isDisplayed()
                && loanTenure.isDisplayed();
    }

    public void enterLoanAmount(String amount) {

        loanAmount.sendKeys(Keys.CONTROL + "a");
        loanAmount.sendKeys(Keys.BACK_SPACE);
        loanAmount.sendKeys(amount);
    }

    public String getLoanAmountValue() {

        return loanAmount.getAttribute("value");
    }

    public int getSliderLocation() {

        return loanAmountSlider.getLocation().getX();
    }

    public void moveLoanAmountSlider() {

        Actions act = new Actions(driver);

        act.dragAndDropBy(loanAmountSlider, 60, 0).perform();
    }

    public void enterInterestAmount(String amount) {

        interestRate.sendKeys(Keys.CONTROL + "a");
        interestRate.sendKeys(Keys.BACK_SPACE);
        interestRate.sendKeys(amount);
    }

    public String getInterestAmountValue() {

        return interestRate.getAttribute("value");
    }

    public int getInterestSliderLocation() {

        return interestSlider.getLocation().getX();
    }

    public void moveInterestAmountSlider() {

        Actions act = new Actions(driver);

        act.dragAndDropBy(interestSlider, 60, 0).perform();
    }

    public void clickYear(){
        yearsBtn.click();
    }

    public void clickMonth(){
        monthsBtn.click();
    }



    public void enterTenureAmount(String amount) {

        loanTenure.sendKeys(Keys.CONTROL + "a");
        loanTenure.sendKeys(Keys.BACK_SPACE);
        loanTenure.sendKeys(amount);
    }

    public String getTenureAmountValue() {

        return loanTenure.getAttribute("value");
    }

    public int getTenureSliderLocation() {

        return tenureSlider.getLocation().getX();
    }

    public void moveTenureAmountSlider() {

        Actions act = new Actions(driver);

        act.dragAndDropBy(tenureSlider, 60, 0).perform();
    }

    public void enterfeesAmount(String amount) {

        loanFees.sendKeys(Keys.CONTROL + "a");
        loanFees.sendKeys(Keys.BACK_SPACE);
        loanFees.sendKeys(amount);
    }

    public String getfeesAmountValue() {

        return loanFees.getAttribute("value");
    }

    public int getfeesSliderLocation() {

        return feesSlider.getLocation().getX();
    }

    public void movefeesAmountSlider() {

        Actions act = new Actions(driver);

        act.dragAndDropBy(feesSlider, 60, 0).perform();
    }

    public void enterEMIAmount(String amount) {

        emi.sendKeys(Keys.CONTROL + "a");
        emi.sendKeys(Keys.BACK_SPACE);
        emi.sendKeys(amount);
    }

    public String getEMIAmountValue() {

        return emi.getAttribute("value");
    }

    public int getEMISliderLocation() {

        return emiSlider.getLocation().getX();
    }

    public void moveEMIAmountSlider() {

        Actions act = new Actions(driver);

        act.dragAndDropBy(emiSlider, 60, 0).perform();
    }
}
