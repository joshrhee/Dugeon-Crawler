import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.*;
import scenes.Configure;
import scenes.GameScene;

public class RahulM5 extends ApplicationTest {
    private Stage mainWindow;

    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Configure config = new Configure(mainWindow);
        config.start(mainWindow);
    }

    @Test
    public void checkInventoryFull() {
        type(KeyCode.T);
        type(KeyCode.E);
        type(KeyCode.S);
        type(KeyCode.T);
        clickOn(".combo-box-base");
        clickOn("Easy");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        clickOn("Potion: Health");
        clickOn("Potion: Health");
        clickOn("Potion: Health");
        clickOn("Potion: Health");
        clickOn("Potion: Health");
        clickOn("Potion: Health");
        verifyThat("Inventory Full", NodeMatchers.isNotNull());
    }
    @Test
    public void testHealthPotion() {
        type(KeyCode.T);
        type(KeyCode.E);
        type(KeyCode.S);
        type(KeyCode.T);
        clickOn(".combo-box-base");
        clickOn("Easy");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        clickOn("Potion: Health");
        Scene scene = mainWindow.getScene();
        GameScene gameScene = (GameScene) scene.getRoot();
        Player player = gameScene.getCurr().getPlayer();
        player.getInventory().get(1).activate();
        assertEquals(120, player.getHealth());

    }
}