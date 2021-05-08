import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.*;
import resources.Player;
import sample.Main;
import scenes.GameScene;

public class RezaM5 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);
    }

    @Test
    public void testAttackPotion() {
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
        robotContext().setPointPosition(Pos.CENTER);

        clickOn("Potion: Attack");

        Scene scene = mainWindow.getScene();
        GameScene gameScene = (GameScene) scene.getRoot();
        Player player = gameScene.getCurr().getPlayer();
        player.getInventory().get(1).activate();
        assertEquals(player.getIncreasedAttack(), 10);
    }
    @Test
    public void testShieldPotion() {
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
        robotContext().setPointPosition(Pos.CENTER);

        clickOn("Potion: Shield");

        Scene scene = mainWindow.getScene();
        GameScene gameScene = (GameScene) scene.getRoot();
        Player player = gameScene.getCurr().getPlayer();
        player.getInventory().get(1).activate();
        assertEquals(player.getShield(), 7);
    }
}
