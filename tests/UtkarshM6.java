import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import resources.Player;
import resources.Weapon;
import scenes.WinningScreen;

import static org.junit.Assert.assertEquals;

public class UtkarshM6 extends ApplicationTest {
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
    public void testCorrectMoney() {
        int correctMoney = player.getMoneyValue();
        int displayedMoney = winningScreen.getMoneyVal();

        assertEquals(correctMoney, displayedMoney);
    }

    @Test
    public void testCorrectHit() {
        int correctMoney = player.getTotalHitCount();
        int displayedMoney = winningScreen.getTotalHittingCount();

        assertEquals(correctMoney, displayedMoney);
    }
}
