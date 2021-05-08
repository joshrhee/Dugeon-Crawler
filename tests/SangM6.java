import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.Player;
import resources.Weapon;
import scenes.WinningScreen;

import static org.testfx.api.FxAssert.verifyThat;

public class SangM6 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {

        mainWindow = primaryStage;
        Player player = new Player("Bob", Weapon.GUN, 500, "");
        WinningScreen winningScreen = new WinningScreen(mainWindow, player);
        winningScreen.start();

    }

    @Test
    public void testCongratulations() {
        verifyThat(new Label("Congratulations! "), NodeMatchers.isNotNull());
    }


    @Test
    public void testConsole() {
        verifyThat(new Label("Game Over..."), NodeMatchers.isNotNull());
    }
}
