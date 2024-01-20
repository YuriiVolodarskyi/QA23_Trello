package tests;

import manager.ApplicationManager;
import models.UserDTO;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    UserDTO user = UserDTO.builder()
            .email("alexmedqwerty1@gmail.com")
            .password("QwertyZXC123!")
            .build();

    @BeforeSuite
    public void setUp(){
        app.init();
    }
    @AfterSuite
    public void tearDown(){
        //app.stop();
    }


}
