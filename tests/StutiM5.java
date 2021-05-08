import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.Player;
import sample.Main;
import scenes.GameScene;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class StutiM5 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);
    }

    @Test
    public void testBuyShieldPotion() {
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
        assertEquals(750, player.getMoneyValue());

        clickOn("Potion: Shield");
        assertEquals(400, player.getMoneyValue());
        clickOn("Potion: Shield");
        clickOn("Potion: Shield");

        verifyThat("Not enough money!", NodeMatchers.isNotNull());
    }

    @Test
    public void testBuyWeapons() {
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
        assertEquals(750, player.getMoneyValue());

        clickOn("Weapon: Spear");
        assertEquals(550, player.getMoneyValue());

        clickOn("Weapon: Sword");
        assertEquals(350, player.getMoneyValue());

        clickOn("Weapon: Gun");
        assertEquals(150, player.getMoneyValue());

        clickOn("Weapon: Spear");

        verifyThat("Not enough money!", NodeMatchers.isNotNull());
    }
}
