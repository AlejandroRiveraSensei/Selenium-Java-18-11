package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests {

    private static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void loginBlocked(){

        //PreCondicion: navegar https://www.saucedemo.com/
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.saucedemo.com/");

        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("locked_out_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Validar que el mensaje contenga "Sorry, this user has been locked out"
        String actualText = driver.findElement(By.cssSelector("h3[data-test = 'error']")).getText();
        String expectedText = "Sorry, this user has been locked out";
        boolean isExpectedText =  actualText.contains(expectedText);
        Assert.assertTrue(isExpectedText);
    }

    @Test
    public void loginSuccess(){
        //PreCondicion: navegar https://www.saucedemo.com/
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.saucedemo.com/");

        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Validar que el text de "Products" desplegado
        //WebElement title = driver.findElement(By.className("title"));
        //Assert.assertEquals(title.getText(),"Products");

        // ----- Explicit Wait -----
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title")));
        Assert.assertEquals(title.getText(),"Products");
    }

    @Test
    public void loginEmptyFields(){
        driver.findElement(By.id("login-button")).click();

        String error = driver.findElement(By.cssSelector("h3[data-test = 'jksdfkjh']")).getText();
        Assert.assertTrue(error.contains("Username is required"));
    }

    @Test
    public void logoutTest(){
        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Step 4: Hhacer click en hamburguer menu
        driver.findElement(By.id("react-burger-menu-btn")).click();

        // ---- Fluent Wait ----
        // espera avanzada donde podemos configurar:
        // - el tiempo total de espera
        // - la frecuencia de busqueda (polling)
        // - que excepcion

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        WebElement logoutLink = fluentWait.until(driver -> driver.findElement(By.id("logout_sidebar_link")));
        logoutLink.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown(){
        //metodo que toma screenshow
        //Cerrar DB
        //driver.quit();
    }

}
