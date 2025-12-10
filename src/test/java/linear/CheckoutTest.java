package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class CheckoutTest {

    private WebDriver driver;

    @BeforeMethod
    public void startUp(){
        ChromeOptions options = new ChromeOptions();
        Map<Object,Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service",false);
        prefs.put("profile.password_manager_enabled",false);
        prefs.put("profile.password_manager_leak_detection",false);
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.addArguments();
        options.setExperimentalOption("prefs",prefs);

        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Test
    public void checkoutNoData(){
        //Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2: Add item and click in Shopping Cart
        driver.findElement(By.xpath("//*[@data-test = 'add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@data-test = 'shopping-cart-link']")).click();

        //Step 3: Click in Checkout
        driver.findElement(By.name("checkout")).click();

        //Step 4: Click en Continues
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        //Validacion
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class = 'error-message-container error']"))
                .isDisplayed(),"El elemento con error no esta desplegado");

        //Validar el que el error contenga el mensaje: "Error: First Name is required"
        Assert.assertTrue(driver.findElement(By.xpath("//h3[@data-test = 'error']")).getText()
                .contains("First Name is required"));
    }

    @Test
    public void checkoutComplete() {
        //Step 1: Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        //Step 2: Add item and click in Shopping Cart
        driver.findElement(By.xpath("//*[@data-test = 'add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.xpath("//*[@data-test = 'shopping-cart-link']")).click();

        //Step 3: Click in Checkout
        driver.findElement(By.name("checkout")).click();

        //Step 4: LLenar el formulario
        driver.findElement(By.id("first-name")).sendKeys("Alejandro");
        driver.findElement(By.id("last-name")).sendKeys("Sensei");
        driver.findElement(By.id("postal-code")).sendKeys("90210");

        //Step 5: Click en Continues
        driver.findElement(By.xpath("//input[@value = 'Continue']")).click();

        //Step 6: Click in Finish
        driver.findElement(By.id("finish")).click();

        //Validacion
        Assert.assertEquals(driver.findElement(By.xpath("//h2[@data-test = 'complete-header']")).getText()
                ,"Thank you for your order!");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
