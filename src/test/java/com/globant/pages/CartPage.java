package com.globant.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    @FindBy(id="remove-sauce-labs-fleece-jacket")
    private WebElement removeFleeceJacketButton;
    @FindBy(id="remove-test.allthethings()-t-shirt-(red)")
    private WebElement removeTShirtButton;
    @FindBy(id="remove-sauce-labs-backpack")
    private WebElement removeBackpackButton;
    @FindBy(id="checkout")
    private WebElement checkoutButton;
    @FindBy(className = "cart_list")
    private WebElement cartListDiv;
    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void removeThreeProductsFromCart(){
        clickElement(removeBackpackButton);
        clickElement(removeTShirtButton);
        clickElement(removeFleeceJacketButton);
    }


    public List<WebElement> getCartItems() {
        return cartListDiv.findElements(By.cssSelector("div.cart_item"));
    }

    public CheckoutPage goToCheckoutPage(){
        clickElement(checkoutButton);
        return new CheckoutPage(getDriver());
    }
}
