package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver driver) {
        super(driver);
    }

    By buttonLogin = By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    By inputLogin = By.id("username");
    By buttonContinue = By.id("login-submit");
    By inputPassword = By.id("password");
    By buttonLoginSubmit = By.id("login-submit");
    By buttonAccount = By.xpath("//button[@data-testid='header-member-menu-button']");



    public void login(String email, String password) {
        clickBase(buttonLogin);
        typeBase(inputLogin,email);
        clickBase(buttonContinue);
        typeBase(inputPassword,password);
        clickBase(buttonLoginSubmit);
    }

    public boolean isElementPresent_ButtonAccount(){
        return isElementPresent(buttonAccount);
    }
}
