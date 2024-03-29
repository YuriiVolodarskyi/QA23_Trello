package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelperProfile extends HelperBase {
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By buttonManageAccount = By.xpath("//a[@data-testid='manage-account-link']");

    By buttonProfilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");

    By buttonChangeProfilePhoto = By.xpath("//button[@data-testid='change-avatar']");

    By buttonUploadPhoto = By.xpath("//input[@id='image-input']");
    By buttonUpload = By.xpath("//button[@type='submit']");
    By popUpAvatarAdded = By.xpath("//span[text()='Avatar added']");

    public void changeAvatar() {
        clickBase(buttonAccount);
        clickBase(buttonManageAccount);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String s : tabs)
            System.out.println("--->" + s);
        driver.switchTo().window(tabs.get((1)));
        pause(5);
        clickBase(buttonProfilePhoto);
        clickBase(buttonChangeProfilePhoto);
        File file = new File("src/test/resources/cat2.jpeg");
        String path = file.getAbsolutePath();
        WebElement element  = driver.findElement(buttonUploadPhoto);
        element.sendKeys(path);
        pause(5);
        clickBase(buttonUpload);
    }

    public boolean isTextInElementPresentByWait_AvatarAdded() {
        return isTextInElementPresentByWait(popUpAvatarAdded, "Avatar added", 10);
    }
}
