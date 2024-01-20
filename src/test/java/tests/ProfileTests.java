package tests;

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

    }


}
