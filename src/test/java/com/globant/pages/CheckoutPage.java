package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    @FindBy(id="first-name")
    private WebElement firstNameInput;
    @FindBy(id="last-name")
    private WebElement lastNameInput;
    @FindBy(id="postal-code")
    private WebElement zipCodeInput;
    @FindBy(id="continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterPersonalInfo(String firstName, String lastName, String zipCode) {
        typeText(firstNameInput,firstName);
        typeText(lastNameInput,lastName);
        typeText(zipCodeInput, zipCode);
    }

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public WebElement getZipCodeInput() {
        return zipCodeInput;
    }

    public OverviewPage goToOverviewPage() {
        clickElement(continueButton);
        return new OverviewPage(getDriver());
    }
}
