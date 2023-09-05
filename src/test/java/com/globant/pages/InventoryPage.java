package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement addBackpackButton;
    @FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement addTShirtButton;
    @FindBy(id="add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addFleeceJacketButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public void addBackpackToCart(){
        clickElement(addBackpackButton);
    }

    public void addThreeProductsToCart(){
        clickElement(addBackpackButton);
        clickElement(addTShirtButton);
        clickElement(addFleeceJacketButton);
    }
}
