package com.globant.components;

import com.globant.pages.BasePage;
import com.globant.pages.CartPage;
import com.globant.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBarComponent extends BasePage {
    @FindBy(className = "shopping_cart_link")
    private WebElement shoppingCartLink;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement hamburgerMenuButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;
    public TopBarComponent(WebDriver driver) {
        super(driver);
    }

    public CartPage goToCartPage(){
        clickElement(shoppingCartLink);
        return new CartPage(getDriver());
    }

    public LoginPage logout(){
        clickElement(hamburgerMenuButton);
        clickElement(logoutLink);
        return new LoginPage(getDriver());
    }
}
