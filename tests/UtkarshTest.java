import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import sample.Main;

import static org.testfx.api.FxAssert.verifyThat;

public class UtkarshTest extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(primaryStage);
    }

    // Utkarsh Nattamai Subramanian Rajkumar's Test
    // Tests to see if the proceed button will not work when no name is entered.
    @Test
    public void testNoNameConfigureScreen() {
        clickOn("Start");
        clickOn(".combo-box-base");
        clickOn("Easy");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        verifyThat("Configure Game Screen", NodeMatchers.isNotNull());
    }

    // Utkarsh Nattamai Subramanian Rajkumar's Test
    // Tests to make sure proceed button will not work when there is whitespace in name.
    @Test
    public void testNoWhiteSpaceConfigureScreen() {
        clickOn("Start");
        type(KeyCode.SPACE);
        clickOn(".combo-box-base");
        clickOn("Easy");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        verifyThat("Configure Game Screen", NodeMatchers.isNotNull());
    }

    public Stage returnStage() {
        return mainWindow;
    }
}
