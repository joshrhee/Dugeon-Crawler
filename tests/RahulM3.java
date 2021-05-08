import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import scenes.*;
import static org.testfx.api.FxAssert.verifyThat;

public class RahulM3 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Configure config = new Configure(mainWindow);
        config.start(mainWindow);
    }

    @Test
    public void testConfigToStartRoom() {
        type(KeyCode.T);
        type(KeyCode.E);
        type(KeyCode.S);
        type(KeyCode.T);
        clickOn(".combo-box-base");
        clickOn("Medium");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        verifyThat("Starting Room", NodeMatchers.isNotNull());

    }

    @Test
    public void testPlayerDataConsistentInOtherRooms() {
        type(KeyCode.T);
        type(KeyCode.E);
        type(KeyCode.S);
        type(KeyCode.T);
        clickOn(".combo-box-base");
        clickOn("Medium");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        for (int i = 0; i < 65; i++) {
            type(KeyCode.RIGHT);
        }
        verifyThat("test", NodeMatchers.isNotNull());
        verifyThat("Player Health: 100", NodeMatchers.isNotNull());
        verifyThat("Money: 500", NodeMatchers.isNotNull());
    }

    public Stage returnStage() {
        return mainWindow;
    }
}