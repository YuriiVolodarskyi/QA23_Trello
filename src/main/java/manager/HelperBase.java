package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {
    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By locator){
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        return driver.findElements(locator);
    }

    public void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator){
        WebElement element = findElementBase(locator);
        element.click();
    }

    public void typeBase(By locator, String test){
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(test);
    }

    public boolean isElementPresent(By locator){
        return !driver.findElements(locator).isEmpty();
    }

}
