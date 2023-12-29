package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardTests extends TestBase{

    @BeforeClass
    public void login(){
       app.getHelperUser().login("alexmedqwerty1@gmail.com", "QwertyZXC123!");
    }

    @Test
    public void addNewBoardPositiveTest(){
        System.out.println("First");
    }

    @Test
    public void deletePositiveTest(){
        System.out.println("Second");
    }
}
