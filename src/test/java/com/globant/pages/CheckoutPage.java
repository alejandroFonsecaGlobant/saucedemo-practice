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
    private WebElement postalCodeInput;
    @FindBy(id="continue")
    private WebElement continueButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void enterPersonalInfo() {
        typeText(firstNameInput,"Alejandro");
        typeText(lastNameInput,"Fonseca");
        typeText(postalCodeInput, "760001");
    }

    public void continueCheckout() {
        clickElement(continueButton);
    }
}
