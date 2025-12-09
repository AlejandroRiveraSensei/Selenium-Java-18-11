package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class InventoryTests {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public  void addProduct(){
        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Step 4: Hacer click en el boton de Add to Cart
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        //Step 5: Obtener el numero/text del WebElement del carrito de compras
        String count = driver.findElement(By.xpath("//*[@data-test = 'shopping-cart-badge']")).getText();

        //Validacion final
        Assert.assertEquals(count,"1");
    }

    @Test
    public void validateRemoveProduct(){
        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Step 4: Hacer click en el boton de Add to Cart
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();

        //Step 5: Hacer clicl en Remove
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        boolean badgeVisbile = driver.findElements(By.xpath("//*[@data-test = 'shopping-cart-badge']")).isEmpty();
        Assert.assertTrue(badgeVisbile);
    }

    @Test
    public void viewProductDetails(){

        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Step 4: Hacer click en el item
        driver.findElement(By.xpath("//*[@data-test = 'inventory-item-name']")).click();

        //Validacion
        String item = driver.findElement(By.xpath("//*[@data-test = 'inventory-item-desc']")).getText();

        Assert.assertTrue(item.contains("sleek"));
        Assert.assertTrue(item.contains("streamlined"));
        Assert.assertFalse(item.isEmpty());
    }


    @AfterMethod
    public void tearDown(){
        //metodo que toma screenshow
        //Cerrar DB
        driver.quit();
    }
}
