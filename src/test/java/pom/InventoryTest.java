package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.UserData;

public class InventoryTest extends BaseTest{

    @Test
    public void addProduct(){
        //Step 1: Login
        login.login(UserData.getUserName("standard"),UserData.getPassword("standard"));
        //Step 2: Hacer click en agregar producto
        inventory.clickAddBackPack();
        //Validar que en el carrito de compra haya un "1"
        Assert.assertEquals(inventory.getBadgeCounter(),"1");
    }

    @Test
    public void removeProduct(){
        //Step 1: Login
        login.login(UserData.getUserName("standard"),UserData.getPassword("standard"));

        //Step 2: Hacer click en agregar producto
        inventory.clickAddBackPack();

        //Step 3: Hacer click en remover producto
        inventory.clickRemoveBackPack();

        //Validacion revisar el conteo de badge
        Assert.assertFalse(inventory.isBadgeCounterVisible());
    }

    @Test
    public void viewProductDetails(){
        //Step 1: Login
        login.login(UserData.getUserName("standard"),UserData.getPassword("standard"));

        //Step 2: hacer click en el primer producto
        inventory.clickFirstProd();

        //Validacion revisar que el texto no este vacio
        String prodDetails = inventory.getFirstProdText();
        Assert.assertFalse(prodDetails.isEmpty());
    }


}
