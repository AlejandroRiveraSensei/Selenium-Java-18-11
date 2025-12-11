package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage{

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    //WebElement
    private final By logoutLink = By.xpath("//*[@data-test = 'about-sidebar-link']/following::a");
    private final By aboutLink = By.id("about_sidebar_link");

    //Methods/Actions de MenuPage
    public void clickLogout(){
        click(logoutLink);
    }

    public void clickAbout(){
        click(aboutLink);
    }
}
