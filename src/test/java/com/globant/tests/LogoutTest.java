package com.globant.tests;

import com.globant.pages.LoginPage;
import com.globant.components.TopBarComponent;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Parameters()
    @Test
    public void logout() {
        String LOGIN_HEADER = "Swag Labs";
        LoginPage loginPage = topBarComponent.logout();
        Assert.assertEquals(loginPage.getLoginHeaderText(), LOGIN_HEADER);
    }
}
