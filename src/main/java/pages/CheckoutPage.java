package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //WebElements
    private final By firstNameInput = By.id("first-name");
    private final By lastNameInput = By.id("last-name");
    private final By postalCodeInput = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By finishBtn = By.id("finish");

    //Actions/Methods
    public void fillCheckOut(String name, String lastname, String postalCode){
        type(firstNameInput,name);
        type(lastNameInput,lastname);
        type(postalCodeInput,postalCode);
    }

    public void clickContinue(){
        click(continueBtn);
    }

    public void clickfinishBtn(){
        click(finishBtn);
    }
}
