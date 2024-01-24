package tests;

import manager.ApplicationManager;
import models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    Logger logger= LoggerFactory.getLogger(TestBase.class);
    UserDTO user = UserDTO.builder()
            .email("alexmedqwerty1@gmail.com")
            .password("QwertyZXC123!")
            .build();

    @BeforeSuite
    public void setUp(){
        logger.info("start method BeforeSuite");
        app.init();
    }
    @AfterSuite
    public void tearDown(){
        logger.info("start method AfterSuite");
        //app.stop();
    }


}
