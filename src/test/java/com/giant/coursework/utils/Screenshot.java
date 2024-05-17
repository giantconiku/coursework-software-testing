package com.giant.coursework.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Screenshot {

    public static void getScreenshot(String failedMethodName) throws IOException {

        LocalDateTime dateTime = LocalDateTime.now();
        String currentDate = dateTime.format(DateTimeFormatter
                .ofPattern("yyyy-MM-dd_HH-mm-ss", Locale.ENGLISH));

        File src = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("test-output\\failure-screenshots\\TestFail_"
                + currentDate + "_" + failedMethodName + ".png"));
    }
}
