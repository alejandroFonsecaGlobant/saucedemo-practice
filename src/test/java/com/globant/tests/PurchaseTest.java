package com.globant.tests;

import com.globant.components.TopBarComponent;
import com.globant.pages.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {
    @Test
    @Parameters({"firstname", "lastname", "zipcode"})
    public void purchaseOneProduct(String firstname, String lastname, String zipCode) {
        String THANK_YOU_MESSAGE = "Thank you for your order!";

        inventoryPage.addBackpackToCart();
        CartPage cart = topBarComponent.goToCartPage();
        Assert.assertEquals(cart.getCartItems().size(),1);

        CheckoutPage checkout = cart.goToCheckoutPage();
        checkout.enterPersonalInfo(firstname, lastname, zipCode);
        Assert.assertEquals(checkout.getFirstNameInput().getAttribute("value"), firstname);
        Assert.assertEquals(checkout.getLastNameInput().getAttribute("value"), lastname);
        Assert.assertEquals(checkout.getZipCodeInput().getAttribute("value"), zipCode);

        OverviewPage overview = checkout.goToOverviewPage();
        ThankYouPage thankYou = overview.finishCheckout();
        Assert.assertEquals(thankYou.getThankYouMessage(), THANK_YOU_MESSAGE);
    }
}
