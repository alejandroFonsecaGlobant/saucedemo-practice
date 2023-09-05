package com.globant.tests;

import com.globant.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;

    @BeforeSuite(alwaysRun = true)
    public void webDriverSetup(){
        /*WebDriverManager.chromedriver().setup();*/
        System.out.println("WebDriver setup done");
    }

    @Parameters("url")
    @BeforeMethod(alwaysRun = true)
    public void testSetup (String url) {
        /*driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        loginPage = new LoginPage(driver);*/
        System.out.println("Test setup done");
    }

    @AfterMethod(alwaysRun = true)
    public void testTeardown(){
        /*driver.quit();*/
        System.out.println("Test teardown done");
    }
}
