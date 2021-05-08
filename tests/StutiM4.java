import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.Monster;
import resources.Player;
import sample.Main;
import scenes.GameScene;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.testfx.api.FxAssert.verifyThat;

public class StutiM4 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);
    }

    @Test
    public void testPlayerHealthBar() throws InterruptedException {
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
        Player player = gameScene.getCurr().getPlayer();

        verifyThat("Player Health: 100", NodeMatchers.isNotNull());
        player.setHealth(73);
        Thread.sleep(1000);
        verifyThat("Player Health: 73", NodeMatchers.isNotNull());
    }

    @Test
    public void testPlayerChangeRoom() throws InterruptedException {
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

        String roomNum1 = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Starting Room", roomNum1);

        for (int i = 0; i < 20; i++) {
            type(KeyCode.UP);
        }
        Thread.sleep(1000);

        Monster monster = gameScene.getCurr().getMonster();
        boolean monsterIsDead = monster.getIsDead();

        assertFalse(monsterIsDead);

        String roomNum2 = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 1", roomNum2);

        for (int i = 0; i < 30; i++) {
            type(KeyCode.DOWN);
        }

        assertEquals("Starting Room", roomNum1);
    }
}
