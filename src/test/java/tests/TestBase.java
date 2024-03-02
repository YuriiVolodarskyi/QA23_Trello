package tests;

import manager.ApplicationManager;
import models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import utils.ConfigProperties;

public class TestBase {
    static ApplicationManager app = new ApplicationManager();
    Logger logger= LoggerFactory.getLogger(TestBase.class);
    /*UserDTO user = UserDTO.builder()
            .email("alexmedqwerty1@gmail.com")
            .password("QwertyZXC123!")
            .build();
     */
    UserDTO user = UserDTO.builder()
            .email(ConfigProperties.getProperties("email"))
            .password(ConfigProperties.getProperties("password"))
            .build();
    @BeforeSuite(alwaysRun = true)
    public void setUp(){
        logger.info("start method BeforeSuite");
        app.init();
    }
    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        logger.info("start method AfterSuite");
        //app.stop();
    }


}
