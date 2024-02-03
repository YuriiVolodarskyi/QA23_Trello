package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProfileTests extends TestBase {

    @BeforeClass
    public void loginDTO() {
        app.getHelperUser().loginDTO(user);
    }

    @Test
    public void changeAvatarPositiveTest() {
        app.getHelperProfile().changeAvatar();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresentByWait_AvatarAdded() );

    }


}
