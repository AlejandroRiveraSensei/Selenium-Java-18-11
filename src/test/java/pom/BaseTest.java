package pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import utils.ConfigReader;
import utils.DriverFactory;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTest {

    private WebDriver driver;
    LoginPage login;
    InventoryPage inventory;
    MenuPage menu;
    CartPage cart;
    CheckoutPage checkout;
    CheckoutCompletePage checkComplete;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.initializaDriver();

        login = new LoginPage(driver);
        inventory = new InventoryPage(driver);
        menu = new MenuPage(driver);
        cart = new CartPage(driver);
        checkout = new CheckoutPage(driver);
        checkComplete = new CheckoutCompletePage(driver);

        //DriverFactory.launchUrl("https://www.saucedemo.com/");
        DriverFactory.launchUrl(ConfigReader.get("baseUrl"));
    }

    @AfterMethod
    public void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }

}
