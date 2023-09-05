package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ThankYouPage extends BasePage {

    @FindBy(className = "complete-header")
    private WebElement thankYouHeader;
    public ThankYouPage(WebDriver driver) {
        super(driver);
    }
    public String getThankYouMessage() {
        return thankYouHeader.getText();
    }
}
