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
    private final By addBackPack = By.id("add-to-cart-sauce-labs-backpack");
    private final By removeBackPack = By.id("remove-sauce-labs-backpack");
    private final By cardBadgeCounter = By.className("shopping_cart_badge");
    private final By firstProd = By.className("inventory_item_name");
    private final By firstProdDetails = By.xpath("//*[@data-test = 'inventory-item-desc']");
    private final By shoppingCart = By.className("shopping_cart_link");

    //Methods/Action
    public String getTitleText(){
        return getText(prodLabel);
    }

    public void clickBurgerManu(){
        click(burgerManu);
    }

    public void clickAddBackPack(){
        click(addBackPack);
    }

    public String getBadgeCounter(){
        return getText(cardBadgeCounter);
    }

    public void clickRemoveBackPack(){
        click(removeBackPack);
    }

    public boolean isBadgeCounterVisible(){
        return isElementDisplayed(cardBadgeCounter);
    }

    public void clickFirstProd(){
        click(firstProd);
    }

    public String getFirstProdText(){
        return getText(firstProdDetails);
    }

    public void clickshoppingCart(){
        click(shoppingCart);
    }
}
