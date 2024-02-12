package manager;

import models.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;


public class HelperUser extends HelperBase{

    public HelperUser(WebDriver driver) {
        super(driver);
    }

    By buttonLogin = By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    By inputLogin = By.id("username");
    By buttonContinue = By.id("login-submit");
    By inputPassword = By.id("password");
    By buttonLoginSubmit = By.id("login-submit");
    //By buttonAccount = By.xpath("//button[@data-testid='header-member-menu-button']");
    By buttonLogout = By.xpath("//button[@data-testid='account-menu-logout']");
    By buttonLogoutSubmit = By.id("logout-submit");

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

    public void loginDTO(UserDTO user) {
        clickBase(buttonLogin);
        typeBase(inputLogin, user.getEmail());
        clickBase(buttonContinue);
        typeBase(inputPassword,user.getPassword());
        clickBase(buttonLoginSubmit);
    }

    public void logout() {
        clickBase(buttonAccount);
        clickBase(buttonLogout);
        clickBase(buttonLogoutSubmit);
    }

    public void returnToHomePage() {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
}
