import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import static org.junit.Assert.*;
import sample.Main;
import scenes.GameScene;

public class RezaM4 extends ApplicationTest {

    private Stage mainWindow;
    private GameScene gameScene;
    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);

    }

    @Test
    public void checkDoors() {
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
        gameScene = (GameScene) scene.getRoot();

        if (gameScene.getMaze().getGenNum() == 1) {
            System.out.println(1);
            for (int i = 0; i < 35; i++) {
                type(KeyCode.D);
            }
            assertFalse(gameScene.getCurr().geteDoor().isOpen());
            assertTrue(gameScene.getCurr().getwDoor().isOpen());

        } else if (gameScene.getMaze().getGenNum() == 2) {
            System.out.println(2);
            for (int i = 0; i < 35; i++) {
                type(KeyCode.S);
            }

            assertFalse(gameScene.getCurr().getsDoor().isOpen());
            assertTrue(gameScene.getCurr().getnDoor().isOpen());

        } else if (gameScene.getMaze().getGenNum() == 3) {
            System.out.println(3);
            for (int i = 0; i < 47; i++) {
                type(KeyCode.A);
            }
            assertFalse(gameScene.getCurr().getwDoor().isOpen());
            assertTrue(gameScene.getCurr().geteDoor().isOpen());

        } else if (gameScene.getMaze().getGenNum() == 4) {
            System.out.println(4);
            for (int i = 0; i < 30; i++) {
                type(KeyCode.W);
            }
            assertFalse(gameScene.getCurr().getnDoor().isOpen());
            assertTrue(gameScene.getCurr().getsDoor().isOpen());

        } else if (gameScene.getMaze().getGenNum() >= 5) {
            System.out.println(5);
            for (int i = 0; i < 30; i++) {
                type(KeyCode.W);
            }
            assertFalse(gameScene.getCurr().getnDoor().isOpen());
            assertTrue(gameScene.getCurr().getsDoor().isOpen());
        }

    }

    @Test
    public void checkMonsterHealth() {
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
        gameScene = (GameScene) scene.getRoot();

        for (int i = 0; i < 35; i++) {
            type(KeyCode.D);
        }
        String mStat1 = gameScene.getMonsterStats().getText();
        gameScene.getCurr().getMonster().setDamageTaken(30);
        for (int i = 0; i < 4; i++) {
            type(KeyCode.W);
        }
        String mStat2 = gameScene.getMonsterStats().getText();
        assertNotEquals(mStat1, mStat2);
    }
}
