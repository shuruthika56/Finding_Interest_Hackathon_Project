package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.JavascriptExecutor;

public class CommonLocators {

    @FindBy(id = "loanamount")
    WebElement loanAmount;

    @FindBy(id = "loaninterest")
    WebElement interestRate;

    @FindBy(id = "loanterm")
    WebElement loanTenure;
}
