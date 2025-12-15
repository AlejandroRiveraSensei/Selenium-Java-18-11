package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //WebElements
    private final By checkoutButton = By.id("checkout");

    //Actions/Methods
    public void clickCheckoutButton(){
        click(checkoutButton);
    }
}
