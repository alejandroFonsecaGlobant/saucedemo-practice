package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OverviewPage extends BasePage {

    @FindBy(id="finish")
    private WebElement finishButton;
    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public ThankYouPage finishCheckout() {
        clickElement(finishButton);
        return new ThankYouPage(getDriver());
    }
}
