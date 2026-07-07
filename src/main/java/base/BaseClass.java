package base;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigReader;



import java.time.Duration;


public class BaseClass {

    public static WebDriver driver;
    ConfigReader config = new ConfigReader();

    public WebDriver getDriver(String browser) {
        switch(browser) {
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "edge":
                driver=new EdgeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            case "safari":
                driver=new SafariDriver();
                break;
            case "internetexplorer":
                driver=new InternetExplorerDriver();
                break;
            default:
                break;
        }
        return driver;
    }
    @BeforeSuite
    public void setup() {



         driver = getDriver(config.getBrowser());

        driver.manage().window().maximize();

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(config.getUrl());
    }

    @AfterSuite
    public void tearDown() {

      if (driver != null) {
           driver.quit();
     }

    }
}