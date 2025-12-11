package pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPage;
import pages.MenuPage;
import utils.DriverFactory;

public class BaseTest {

    private WebDriver driver;
    LoginPage login;
    InventoryPage inventory;
    MenuPage menu;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void setUp(){
        driver = DriverFactory.initializaDriver();

        login = new LoginPage(driver);
        inventory = new InventoryPage(driver);
        menu = new MenuPage(driver);

        DriverFactory.launchUrl("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
