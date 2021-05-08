import javafx.stage.Stage;
import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;
import resources.Maze;
import resources.Player;
import resources.Weapon;
import sample.Main;
import scenes.GameScene;

import java.util.LinkedList;

public class RezaM3 extends ApplicationTest {
    private Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        Main main = new Main();
        main.start(mainWindow);
    }

    @Test
    public void mazeRandomGenTest() {
        LinkedList<Integer> gens = new LinkedList<Integer>();
        gens.add(1);
        gens.add(2);
        gens.add(3);
        gens.add(4);
        gens.add(5);

        Maze testMaze = new Maze(mainWindow);
        Player p1 = new Player("Bob", Weapon.GUN, 500, "");
        testMaze.getCurrRoom().setPlayer(p1);
        while (gens.size() != 0) {
            if (gens.contains(testMaze.getGenNum())) {
                int x = gens.indexOf(testMaze.getGenNum());
                gens.remove(x);
            }
            testMaze = new Maze(mainWindow);
            testMaze.getCurrRoom().setPlayer(p1);
        }
        assertEquals(gens.size(), 0);
    }

    @Test
    public void roomSwitchingTest() {
        Player p1 = new Player("Bob", Weapon.GUN, 400, "");
        GameScene gameScene = new GameScene(mainWindow, "Test", p1);
        System.out.println(gameScene.getMaze().getGenNum());
        String start = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals(start, "Starting Room");
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom1());
        String temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 1", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom2());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 2", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom3());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 3", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom4());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 4", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom5());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 5", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom6());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 6", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom7());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 7", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom8());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 8", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom9());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Room 9", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getRoom10());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals("Final Room", temp);
        assertNotEquals(start, temp);
        gameScene.getMaze().switchRooms(gameScene.getMaze().getStartRoom());
        temp = gameScene.getMaze().getCurrRoom().getRoomText();
        assertEquals(start, temp);

    }
}
