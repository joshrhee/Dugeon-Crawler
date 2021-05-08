import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.Player;
import resources.Weapon;
import scenes.WinningScreen;

import static org.junit.Assert.assertEquals;
import static org.testfx.api.FxAssert.verifyThat;

public class StutiM6 extends ApplicationTest {
    private Stage mainWindow;
    private Player player;
    private WinningScreen winningScreen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        player = new Player("Bob", Weapon.GUN, 500, "easy");
        winningScreen = new WinningScreen(mainWindow, player);
        winningScreen.start();
    }

    @Test
    public void testStatsExist() {
        verifyThat(new Label("100 health"), NodeMatchers.isNotNull());
        verifyThat(new Label("money is 750"), NodeMatchers.isNotNull());
        verifyThat(new Label("You hit total 0 for all monsters!"), NodeMatchers.isNotNull());
    }

    @Test
    public void testCorrectHealth() {
        int correctHealth = player.getHealth();
        int displayedHealth = winningScreen.getPlayerHealth();

        assertEquals(correctHealth, displayedHealth);
    }
}
