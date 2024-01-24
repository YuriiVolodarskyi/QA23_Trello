package manager;

import models.BoardDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class HelperBoards extends HelperBase {
    public HelperBoards(WebDriver driver) {
        super(driver);
    }

    By buttonCreateNewBoard = By.xpath("//li[@data-testid='create-board-tile']//span");
    By inputBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");
    By buttonCreateBoard = By.xpath("//button[@data-testid='create-board-submit-button']");
    By boardNameDisplay = By.xpath("//h1[@data-testid='board-name-display']");
    By buttonBoards = By.cssSelector("a[data-testid='open-boards-link']");

    //========================
    By buttonDots = By.cssSelector("button[aria-label='Show menu']");
    By buttonCloseBoard =
            By.cssSelector("a[class=\"board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board\"]");
    By buttonCloseConfirm = By.cssSelector("input[value='Close']");
    By buttonDeleteBoard = By.cssSelector("button[data-testid='close-board-delete-board-button']");
    By buttonDeleteConfirm = By.cssSelector("button[data-testid='close-board-delete-board-confirm-button']");
    By deleteMessage = By.cssSelector("div[id='FlagGroup']");
    By deleteMessageText = By.xpath("//span[text()='Board deleted.']");

    //========================
    By listBoard = By.xpath("//ul[@class='boards-page-board-section-list']/li");
    public void deleteElementList() {
        //pause(3);
        List<WebElement> listElements = driver.findElements(listBoard);
        System.out.println("size = " + listElements.size());

    }

    public void createNewBoard(BoardDTO board) {
        pause(2);
        clickBase(buttonCreateNewBoard);
        typeBase(inputBoardTitle, board.getBoardTitle());
        pause(5);
        clickBase(buttonCreateBoard);

    }

    public void deleteBoard(String boardTitle) {
        clickBoardOnTitle(boardTitle);
        driver.navigate().refresh();
        clickBase(buttonDots);
        clickBase(buttonCloseBoard);
        clickBase(buttonCloseConfirm);
        clickBase(buttonDeleteBoard);
        clickBase(buttonDeleteConfirm);
    }

    public void clickBoardOnTitle(String boardTitle) {
        String xPathBoardTitle = "//div[@title='" + boardTitle + "']";
        clickBase(By.xpath(xPathBoardTitle));

    }

    public boolean isBoardTitlePresent(String text) {
        return isTextInElementEquals(boardNameDisplay, text);
    }

    public void clickButtonBoards() {
        clickBase(buttonBoards);
    }

    public boolean isDeleteMessagePresent() {

        return isTextInElementEquals(deleteMessage, "Board deleted.");
    }

    public boolean isTextMessagePresentByText() {
        return isElementPresent(deleteMessageText);
    }

    public boolean isElementPresent_buttonBoards() {
        return isElementPresent(buttonBoards);
    }
}
