package com.globant.tests;

import com.globant.components.TopBarComponent;
import com.globant.pages.InventoryPage;
import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected InventoryPage inventoryPage;

    protected TopBarComponent topBarComponent;
    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){
        WebDriverManager.chromedriver().setup();
    }

    @Parameters({"url","username","password"})
    @BeforeMethod(alwaysRun = true)
    public void testSetup (String url,String username, String password, ITestContext testContext) {
        driver = new ChromeDriver();
        testContext.setAttribute("driver", driver);
        driver.get(url);
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        inventoryPage = loginPage.login(username,password);
        topBarComponent = new TopBarComponent(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void testTeardown(){
        driver.quit();
    }
}
