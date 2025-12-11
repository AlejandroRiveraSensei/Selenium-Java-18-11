package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //WebElements
    private final By prodLabel = By.className("title");
    private final By burgerManu = By.id("react-burger-menu-btn");

    //Methods
    public String getTitleText(){
        return getText(prodLabel);
    }

    public void clickBurgerManu(){
        click(burgerManu);
    }
}
