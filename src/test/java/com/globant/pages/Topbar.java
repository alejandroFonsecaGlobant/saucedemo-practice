package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Topbar extends BasePage {
    @FindBy(className = "shopping-cart-link")
    private WebElement shoppingCartLink;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenuButton;
    @FindBy(id = "logout-sidebar-link")
    private WebElement logoutLink;
    public Topbar(WebDriver driver) {
        super(driver);
    }

    public void clickShoppingCart(){
        clickElement(shoppingCartLink);
    }

    public void logout(){
        clickElement(hamburgerMenuButton);
        clickElement(logoutLink);
    }
}
