package com.globant.pages;

import com.beust.ah.A;
import com.globant.tests.BaseTest;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

import static java.time.temporal.ChronoUnit.SECONDS;

public class BasePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final Actions actions;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.of(5, SECONDS));
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public Actions getActions() {
        return actions;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void clickElement(WebElement webElement) {
        getWait().until(ExpectedConditions.elementToBeClickable(webElement)).click();
    }

    public void typeText(WebElement webElement, String text) {
        getWait().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    public void chooseSelectOptionByValue (WebElement selectElement, String value) {
        Select select = new Select(selectElement);
        select.selectByValue(value);
    }

    public void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }
}
