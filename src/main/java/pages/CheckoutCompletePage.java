package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage{

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    //WebElements
    private final By orderCompleteText = By.className("complete-header");

    //Actions/Methods
    public String getCompleteText(){
        return getText(orderCompleteText);
    }

}
