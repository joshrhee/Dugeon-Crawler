import javafx.stage.Stage;
import org.junit.Test;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.matcher.base.WindowMatchers;

import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.*;
import scenes.WinningScreen;

public class UtkarshM4 extends ApplicationTest {
    private Stage mainWindow;
    private Player p1;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Player p1 = new Player("RB", Weapon.GUN, 250, "");
        WinningScreen winning = new WinningScreen(mainWindow, p1);
        winning.start();
    }

    @Test
    public void testLosingScreenAppears() {
        if (p1 != null && p1.getIsDead()) {
            verifyThat(window("End Screen"), WindowMatchers.isShowing());
        }
    }

    @Test
    public void testRestartButtonExists() {
        if (p1 != null && p1.getIsDead()) {
            verifyThat("Restart", NodeMatchers.isNotNull());
        }
    }

    public Player getP1() {
        return p1;
    }
}