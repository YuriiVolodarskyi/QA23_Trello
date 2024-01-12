package tests;

import models.BoardDTO;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardTests extends TestBase {

    @BeforeClass
    public void loginDTO() {
        app.getHelperUser().loginDTO(UserDTO.builder()
                .email("alexmedqwerty1@gmail.com")
                .password("QwertyZXC123!")
                .build());
    }

    @Test
    public void addNewBoardPositiveTest() {
        int i = new Random().nextInt(1000)+1000;
        BoardDTO board = BoardDTO.builder()
                .boardTitle("board" + i)
                .build();
                app.getHelperBoards().createNewBoard(board);
        Assert.assertTrue(app.getHelperBoards().isBoardTitlePresent(board.getBoardTitle()));
        
    }

    @Test
    public void deletePositiveTest() {
        System.out.println("Second");
    }

    @AfterMethod
    public void afterMethod(){
        app.getHelperBoards().clickButtonBoards();
    }
}
