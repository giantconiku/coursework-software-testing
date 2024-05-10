package com.giant.coursework.utils;

import com.giant.coursework.enums.BrowserType;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Driver {

    private static final BrowserType DEFAULT_BROWSER_TYPE = BrowserType.EDGE;

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {
            initDriver(DEFAULT_BROWSER_TYPE);
        }
        return driver;
    }

    public static WebDriver getDriver(BrowserType browserType) {

        if (driver == null || browserType != DEFAULT_BROWSER_TYPE) {
            initDriver(browserType);
        }
        return driver;
    }

    private static void initDriver(BrowserType browserType) {

        switch (browserType) {

            case CHROME:

                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;

            case FIREFOX:

                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Dell\\Desktop\\geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
                driver = new FirefoxDriver(firefoxOptions);
                break;

            default:

                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
