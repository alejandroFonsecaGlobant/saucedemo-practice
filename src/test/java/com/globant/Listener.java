package com.globant;

import static java.lang.String.format;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public class Listener extends Reporter implements ITestListener {

    private final String FAILED_SS_PATH = "C:\\Users\\alejandro.fonseca\\Documents\\Projects\\saucedemo-practice\\screenshots\\";
    @Override
    public void onTestStart(ITestResult result) {
        logInfo(format("Test: %s - [STARTING...]", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logInfo(format("Test: %s - [PASSED]", result.getName()));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logError(format("Test: %s - [FAIL]", result.getName()));
        ITestContext context = result.getTestContext();

        String methodName = result.getMethod().getMethodName().trim();
        String date = context.getStartDate().toString().replace(':','_');
        String scrName = methodName + " " + date;

        WebDriver driver = (WebDriver) context.getAttribute("driver"); // Retrieve the driver
        takeScreenshot(scrName, driver);
        logError("Screenshot stored in screenshot folder with name: " + scrName);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logWarning(format("Test: %s - [SKIPPED]", result.getName()));
    }

    public void takeScreenshot(String scrName, WebDriver driver) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(FAILED_SS_PATH +
                    scrName + ".jpg"));
        } catch (IOException e) {
            logError("Screenshot couldn't be taken: IOException");
        }
    }
}
