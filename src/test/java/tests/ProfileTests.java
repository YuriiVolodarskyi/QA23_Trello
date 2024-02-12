package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase {

    @BeforeClass
    public void loginDTO() {
        app.getHelperUser().loginDTO(user);
    }

    @Test(groups = {"positive", "smoke"})
    public void changeAvatarPositiveTest() {
        app.getHelperProfile().changeAvatar();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresentByWait_AvatarAdded());

    }

    @AfterMethod (alwaysRun = true)
    public void afterTest(){
        app.getHelperUser().returnToHomePage();
    }

    @AfterClass(alwaysRun = true)
    public void logout(){
        app.getHelperUser().logout();
    }

}
