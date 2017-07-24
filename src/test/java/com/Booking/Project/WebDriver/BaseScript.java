package com.Booking.Project.WebDriver;


import com.Booking.Project.logging.EventHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import java.util.concurrent.TimeUnit;

/**
 * Base script functionality, can be used for all Selenium scripts.
 */
public abstract class BaseScript {
    /**
     * @return New instance of {@link WebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */
    public static WebDriver getDriver(String browser) {

        switch (browser) {
            // TODO prepare required WebDriver instance according to browser type
            case "opera" :
                System.setProperty("webdriver.opera.driver", "C:\\Test2\\TechnicalTestOfBookingComSite\\src\\main\\resources\\operadriver.exe");
                return new OperaDriver();
            case "edge":
                System.setProperty("webdriver.ie.driver", "C:\\Test2\\TechnicalTestOfBookingComSite\\src\\main\\resources\\IEDriverServer.exe");
                return new InternetExplorerDriver();
            case "chrome":
            default:
                System.setProperty(
                        "webdriver.chrome.driver", "C:\\Test2\\TechnicalTestOfBookingComSite\\src\\main\\resources\\chromedriver.exe");
                return new ChromeDriver();
        }
    }

    /**
     * Creates {@link WebDriver} instance with timeout and browser window configurations.
     *
     * @return New instance of {@link EventFiringWebDriver} object. Driver type is based on passed parameters
     * to the automation project, returns {@link ChromeDriver} instance by default.
     */

    public static WebDriver getConfiguredDriver(String browser) throws UnsupportedOperationException {
        // TODO configure browser window (set timeouts, browser pindow position) and connect loggers
        EventFiringWebDriver driver = new EventFiringWebDriver (getDriver(browser));
        driver.register(new EventHandler());
        if (driver != null) {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
            return  driver;
        }
        throw new UnsupportedOperationException("Method doesn't return configured WebDriver instance");
    }
}


