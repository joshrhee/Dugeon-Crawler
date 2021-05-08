import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import sample.Main;

import static org.testfx.api.FxAssert.verifyThat;
public class RezaTest extends ApplicationTest {

    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(primaryStage);
    }

    @Test
    public void testMediumMoneyValue() {
        clickOn("Start");
        type(KeyCode.N);
        type(KeyCode.A);
        type(KeyCode.M);
        type(KeyCode.E);
        clickOn(".combo-box-base");
        clickOn("Medium");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        verifyThat("Money: 500", NodeMatchers.isNotNull());


    }
    @Test
    public void testDifficultMoneyValue() {
        clickOn("Start");
        type(KeyCode.N);
        type(KeyCode.A);
        type(KeyCode.M);
        type(KeyCode.E);
        clickOn(".combo-box-base");
        clickOn("Difficult");
        type(KeyCode.TAB);
        type(KeyCode.DOWN);
        type(KeyCode.ENTER);
        clickOn("Proceed!");
        verifyThat("Money: 750", NodeMatchers.isNotNull());


    }
}
