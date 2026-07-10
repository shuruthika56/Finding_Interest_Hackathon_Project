package base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    ConfigReader config = new ConfigReader();

    public static WebDriver getDriver() {

        return driver.get();
    }

    public WebDriver createDriver(String browser) {

        WebDriver localDriver = null;

        switch (browser.toLowerCase()) {

            case "chrome":
                localDriver = new ChromeDriver();
                break;

            case "edge":

                localDriver = new EdgeDriver();
                break;

            case "firefox":
                localDriver = new FirefoxDriver();
                break;

            case "safari":
                localDriver = new SafariDriver();
                break;

            case "internetexplorer":
                localDriver = new InternetExplorerDriver();
                break;
        }

        return localDriver;
    }

    //    @BeforeSuite
    @BeforeClass
    public void setup() {

        WebDriver localDriver = createDriver(config.getBrowser());

        driver.set(localDriver);

        getDriver().manage().window().maximize();

        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        getDriver().get(config.getUrl());

        System.out.println("Thread ID = "
                + Thread.currentThread().getId());
    }

    //    @AfterSuite
    @AfterClass
    public void tearDown() {

        if (getDriver() != null) {

            getDriver().quit();

            driver.remove();
        }
    }
}