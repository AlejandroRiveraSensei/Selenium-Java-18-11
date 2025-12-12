package pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest{

    @Test
    public void loginBlocked(){
        //Step 1: Login
        login.login("locked_out_user","secret_sauce");
        //Validacion
        Assert.assertTrue(login.getErrorMessage().contains("this user has been locked out"));
    }

    @Test
    public void incorrectLogin(){
        //Step 1: Login
        login.login("incorrect_user","secret_sauce");
        //Validacion
        Assert.assertEquals(login.getErrorMessage(),"Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void loginSuccess(){
        login.login("standard_user","secret_sauce");
        Assert.assertEquals(inventory.getTitleText(),"Products");
    }

    @Test
    public void emptyLogin(){
        login.login("","");
        Assert.assertEquals(login.getErrorMessage(),"Epic sadface: Username is required");
        Assert.assertTrue(login.getErrorMessage().contains("Username is required"));
    }

    @Test
    public void logout(){
        //Step 1: Login
        login.login("standard_user","secret_sauce");

        //Step 2: Click en burger menu
        inventory.clickBurgerManu();

        //Step 3: Click en logout
        menu.clickAbout();
        menu.clickLogout();

        //Verification
        Assert.assertEquals(login.getLoginUrl(),"https://www.saucedemo.com/");
    }

}
