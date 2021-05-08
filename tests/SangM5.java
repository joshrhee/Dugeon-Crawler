import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.Player;
import resources.Weapon;
import scenes.Configure;
import scenes.GameScene;

import static org.junit.Assert.*;
import static org.testfx.api.FxAssert.verifyThat;

public class SangM5 extends ApplicationTest {
    private Stage mainWindow;

    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Configure config = new Configure(mainWindow);
        config.start(mainWindow);
    }

    @Test
    public void testStoreExists() {
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
        verifyThat("STORE: ", NodeMatchers.isNotNull());
    }

    @Test
    public void testWeaponChnage() {
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
        clickOn("Weapon: Sword");
        Scene scene = mainWindow.getScene();
        GameScene gameScene = (GameScene) scene.getRoot();
        Player player = gameScene.getCurr().getPlayer();
        player.getInventory().get(0).activate();
        assertEquals(player.getWeapon(), Weapon.SWORD);
    }
}
