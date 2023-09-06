package com.globant.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id="user-name") private WebElement usernameInput;
    @FindBy(id="password") private WebElement passwordInput;
    @FindBy(id= "login-button") private WebElement loginButton;
    @FindBy(className = "login_logo") private WebElement loginHeader;

    public LoginPage(WebDriver driver){
        super(driver);
    }
    public InventoryPage login(String username, String password) {
        typeText(usernameInput,username);
        typeText(passwordInput,password);
        clickElement(loginButton);
        return new InventoryPage(getDriver());
    }

    public String getLoginHeaderText() {
        return loginHeader.getText();
    }

    public WebElement getLoginButton(){
        return loginButton;
    }
}
