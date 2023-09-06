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
        String EXPECTED_FIRSTNAME = "Alejandro";
        String EXPECTED_LASTNAME = "Fonseca";
        String EXPECTED_ZIPCODE = "760001";

        inventoryPage.addBackpackToCart();
        CartPage cart = topBarComponent.goToCartPage();
        Assert.assertEquals(cart.getCartItems().size(),1);

        CheckoutPage checkout = cart.goToCheckoutPage();
        checkout.enterPersonalInfo(firstname, lastname, zipCode);
        Assert.assertEquals(checkout.getFirstNameInput().getAttribute("value"), EXPECTED_FIRSTNAME);
        Assert.assertEquals(checkout.getLastNameInput().getAttribute("value"), EXPECTED_LASTNAME);
        Assert.assertEquals(checkout.getZipCodeInput().getAttribute("value"), EXPECTED_ZIPCODE);

        OverviewPage overview = checkout.goToOverviewPage();
        ThankYouPage thankYou = overview.finishCheckout();
        Assert.assertEquals(thankYou.getThankYouMessage(), THANK_YOU_MESSAGE);
    }
}
