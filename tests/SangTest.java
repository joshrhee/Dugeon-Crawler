import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import sample.Main;

import static org.testfx.api.FxAssert.verifyThat;

public class SangTest extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(primaryStage);
    }

    //Sang June Rhee's Test
    //Clicking "Help" button on WelcomeScreen and see "Go back" button exist on there
    @Test
    public void testHelpButton() {
        clickOn("Help");
        verifyThat("Go back", NodeMatchers.isNotNull());
    }

    //Sang June Rhee's Test
    //Clicking "Exit" button on WelcomeScreen and see "Yes" button exist on there
    @Test
    public void testExitButton() {
        clickOn("Exit");
        verifyThat("Yes", NodeMatchers.isNotNull());
    }

    public Stage returnStage() {
        return mainWindow;
    }
}
