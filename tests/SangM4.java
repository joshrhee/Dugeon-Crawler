import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;
import org.testfx.matcher.base.NodeMatchers;
import resources.Monster;
import resources.Player;
import resources.Weapon;
import sample.Main;
import scenes.GameScene;

import static org.testfx.api.FxAssert.verifyThat;
import static org.junit.Assert.*;

//- Check monster bar exists
//- check if monster dies

public class SangM4 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);
    }

    @Test
    public void monsterBarTest() {
        Player p1 = new Player("Bob", Weapon.GUN, 400, "");
        GameScene gameScene = new GameScene(mainWindow, "Test", p1);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom1());
        verifyThat(gameScene.getMonsterStats(), NodeMatchers.isNotNull());
    }

    @Test
    public void monsterDie() {
        Player p1 = new Player("Bob", Weapon.GUN, 400, "");
        GameScene gameScene = new GameScene(mainWindow, "Test", p1);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom1());
        gameScene.setCurr(gameScene.getMaze().getCurrRoom());
        Monster monster = gameScene.getCurr().getMonster();
        monster.setHealth(1);
        monster.setDamageTaken(1);
        assertEquals(monster.isDead(), true);

        verifyThat(gameScene.getMonsterStats(), NodeMatchers.isNotNull());
    }
}
