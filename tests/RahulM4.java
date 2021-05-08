import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;
import resources.*;

public class RahulM4 extends ApplicationTest {

    @Test
    public void easyMonsterCheck() {
        Player easyPlayer = new Player("easyCheck", Weapon.SPEAR, 750, "Easy");
        Monster monsterOne = new MonsterOne(easyPlayer);
        Monster monsterTwo = new MonsterTwo(easyPlayer);
        Monster monsterThree = new MonsterThree(easyPlayer);
        assertEquals(100, monsterOne.getHealth(), 0);
        assertEquals(10, monsterOne.getDamageGivenAmount(), 0);
        assertEquals(50, monsterTwo.getHealth(), 0);
        assertEquals(25, monsterTwo.getDamageGivenAmount(), 0);
        assertEquals(200, monsterThree.getHealth(), 0);
        assertEquals(3, monsterThree.getDamageGivenAmount(), 0);
    }
    @Test
    public void hardMonsterCheck() {
        Player hardPlayer = new Player("hardCheck", Weapon.SPEAR, 250, "Hard");
        Monster monsterOne = new MonsterOne(hardPlayer);
        Monster monsterTwo = new MonsterTwo(hardPlayer);
        Monster monsterThree = new MonsterThree(hardPlayer);
        assertEquals(200, monsterOne.getHealth(), 0);
        assertEquals(20, monsterOne.getDamageGivenAmount(), 0);
        assertEquals(100, monsterTwo.getHealth(), 0);
        assertEquals(45, monsterTwo.getDamageGivenAmount(), 0);
        assertEquals(300, monsterThree.getHealth(), 0);
        assertEquals(9, monsterThree.getDamageGivenAmount(), 0);
    }
}