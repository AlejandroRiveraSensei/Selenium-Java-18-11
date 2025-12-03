package linear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public void loginBlocked(){

        //PreCondicion: navegar https://www.saucedemo.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

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
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        //Step 1: Llenar campo de usario
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //Step 2: Llenar campo de password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        //Step 3: Hacer click en boton login
        driver.findElement(By.xpath("//*[@id = 'login-button']")).click();

        //Validar que el text de "Products" desplegado
        WebElement title = driver.findElement(By.className("title"));
        Assert.assertEquals(title.getText(),"Products");

        driver.quit();
        //driver.close();
    }

}
