package com.globant.tests;

import com.globant.pages.CartPage;
import com.globant.pages.InventoryPage;
import com.globant.components.TopBarComponent;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductsTest extends BaseTest {
    @Test
    public void removeThreeProductsFromCart() {
        inventoryPage.addThreeProductsToCart();
        CartPage cart = topBarComponent.goToCartPage();
        cart.removeThreeProductsFromCart();
        Assert.assertTrue(cart.getCartItems().isEmpty());
    }
}
