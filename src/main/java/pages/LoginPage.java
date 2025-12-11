package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Web Elements de la LoginPage
    private final By userNameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorContainer = By.xpath("//*[@data-test = 'error']");

    //Lo metodos de la LoginPage

    public void login(String username, String password){
        type(userNameInput,username);
        type(passwordInput,password);
        click(loginBtn);
    }

    public String getErrorMessage(){
        return getText(errorContainer);
    }

    public String getLoginUrl(){
        return getCurrentUrl();
    }
}
