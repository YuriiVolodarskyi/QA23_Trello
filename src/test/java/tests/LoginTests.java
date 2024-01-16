package tests;

import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    /*  @Test
    public void loginPositiveTest() {
        app.getHelperUser().login("alexmedqwerty1@gmail.com", "QwertyZXC123!");
        Assert.assertTrue(app.getHelperUser().isElementPresent_ButtonAccount());
        //System.out.println("Start!");
    }
*/
    @Test
    public void loginPositiveTestDTO() {
        UserDTO user = UserDTO.builder()
                .email("alexmedqwerty1@gmail.com")
                .password("QwertyZXC123!")
                .build();
        app.getHelperUser().loginDTO(user);
        app.getHelperUser().pause(3);
        Assert.assertTrue(app.getHelperUser().isElementPresent_ButtonAccount());
        //System.out.println("Start!");
    }

}
