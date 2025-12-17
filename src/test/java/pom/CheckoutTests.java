package pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserData;

public class CheckoutTests extends BaseTest{

    @Test
    public void checkoutSucces(){
        //Step 1: login
        login.login(UserData.getUserName("standard"),UserData.getPassword("standard"));

        //Step 2: agregar producto
        inventory.clickAddBackPack();

        //Step 3: hacer click en carrito de compras
        inventory.clickshoppingCart();

        //Step 4: hacer click en chekcout
        cart.clickCheckoutButton();

        //Step 5: Llenar el formulario y hacer click en continue
        checkout.fillCheckOut("Alejandr","Rivera","91210");
        checkout.clickContinue();

        //Step 6: hacer click en finish
        checkout.clickfinishBtn();

        //Validat el texto "Thank you for your order!" en pantalla
        String actualText = checkComplete.getCompleteText();
        String expectedText = "Thank you for your order!";
        Assert.assertEquals(actualText,expectedText);
    }
}
