import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.*;
import org.testfx.matcher.base.NodeMatchers;
import static org.testfx.api.FxAssert.verifyThat;

import resources.ChallRoom;
import sample.Main;
import scenes.GameScene;

public class RezaM6 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);
    }

    @Test
    public void testChallRoomText() throws InterruptedException {
        clickOn("Start");
        type(KeyCode.N);
        type(KeyCode.A);
        type(KeyCode.M);
        type(KeyCode.E);
        clickOn(".combo-box-base");
        clickOn("Easy");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");

        Scene scene = mainWindow.getScene();
        GameScene gameScene = (GameScene) scene.getRoot();
        Runnable r = () -> {
            gameScene.getMaze().switchRooms(gameScene.getMaze().getcRoom1());
        };
        Platform.runLater(r);
        Thread.sleep(1000);

        verifyThat("Do you wish to start the Challenge Room!", NodeMatchers.isNotNull());

    }
    @Test
    public void testChallRoomButton() throws InterruptedException {
        clickOn("Start");
        type(KeyCode.N);
        type(KeyCode.A);
        type(KeyCode.M);
        type(KeyCode.E);
        clickOn(".combo-box-base");
        clickOn("Easy");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");

        Scene scene = mainWindow.getScene();
        GameScene gameScene = (GameScene) scene.getRoot();
        Runnable r = () -> {
            gameScene.getMaze().switchRooms(gameScene.getMaze().getcRoom1());
        };
        Platform.runLater(r);
        Thread.sleep(1000);
        verifyThat("Start", NodeMatchers.isNotNull());
        clickOn("Start");
        ChallRoom c = (ChallRoom) (gameScene.getCurr());
        assertEquals(c.getMonsters().size(), 3);
    }
}
