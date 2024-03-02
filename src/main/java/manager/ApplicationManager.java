package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.ConfigProperties;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger= LoggerFactory.getLogger(ApplicationManager.class);
    //WebDriver driver;
EventFiringWebDriver driver;

    HelperUser helperUser;
    HelperBoards helperBoards;
    HelperProfile helperProfile;
    static String browser;
    public ApplicationManager(){
        browser = System.getProperty("browser", BrowserType.CHROME);

    }


    public void init(){
        //driver = new ChromeDriver();
        //driver = new EventFiringWebDriver(new ChromeDriver());
        if(browser.equals(BrowserType.FIREFOX)){
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("Created firefox driver");
        } else {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("Created chrome driver");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.navigate().to("https://trello.com/home");
        driver.navigate().to(ConfigProperties.getProperties("url"));
        logger.info("start testing --- navigate to --> https://trello.com/home");
        helperUser = new HelperUser(driver);
        helperBoards = new HelperBoards(driver);
        helperProfile = new HelperProfile(driver);
        driver.register(new WDListener());

    }

    public HelperUser getHelperUser(){
        return helperUser;
    }
    public HelperBoards getHelperBoards(){
        return helperBoards;
    }

    public HelperProfile getHelperProfile(){
        return helperProfile;
    }

    public void stop(){
        driver.quit();
    }

}
