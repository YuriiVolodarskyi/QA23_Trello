package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{
    @Test
    public void loginPositiveTest(){
        app.getHelperUser().login("alexmedqwerty1@gmail.com", "QwertyZXC123!");
        Assert.assertTrue(app.getHelperUser().isElementPresent_ButtonAccount());
        //System.out.println("Start!");
    }

}
