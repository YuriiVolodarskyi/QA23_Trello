package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HelperBase {
    Logger logger= LoggerFactory.getLogger(HelperBase.class);
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    By buttonAccount = By.xpath("//button[@data-testid='header-member-menu-button']");

    private WebElement findElementBase(By locator) {
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {
        return driver.findElements(locator);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator) {
        WebElement element = findElementBase(locator);
        element.click();
    }

    public void typeBase(By locator, String test) {
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(test);
    }

    public boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public boolean isTextInElementEquals(By locator, String text) {
        WebElement element = findElementBase(locator);
        return element.getText().equals(text);
    }




}
