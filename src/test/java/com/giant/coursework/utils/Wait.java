package com.giant.coursework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Wait {

    private static final long DEFAULT_TIMEOUT_IN_SECONDS = 10;
    private static WebDriverWait wait;

    public static WebDriverWait getWait() {

        if (wait == null) {
            initWait(Driver.getDriver(), DEFAULT_TIMEOUT_IN_SECONDS);
        }
        return wait;
    }

    public static WebDriverWait getWait(long timeoutInSeconds) {

        if (wait == null || timeoutInSeconds != DEFAULT_TIMEOUT_IN_SECONDS) {
            initWait(Driver.getDriver(), timeoutInSeconds);
        }
        return wait;
    }

    private static void initWait(WebDriver driver, long timeoutInSeconds) {

        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        } catch (Exception e) {
            System.out.println("Failed to initialize WebDriverWait: " + e.getMessage());
        }
    }
}
