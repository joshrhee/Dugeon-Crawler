import org.junit.Test;
import static org.junit.Assert.*;
import org.testfx.framework.junit.ApplicationTest;
import resources.*;

public class RahulM6 extends ApplicationTest {
    @Test
    public void finalMonsterHealth() {
        Player easy = new Player("easyCheck", Weapon.SPEAR, 750, "Easy");
        Player medium = new Player("mediumCheck", Weapon.SPEAR, 750, "Medium");
        Player difficult = new Player("difficultCheck", Weapon.SPEAR, 750, "Difficult");
        Monster easyFinal = new MonsterFinal(easy);
        Monster mediumFinal = new MonsterFinal(medium);
        Monster difficultFinal = new MonsterFinal(difficult);
        assertEquals(300, easyFinal.getHealth(), 0);
        assertEquals(400, mediumFinal.getHealth(), 0);
        assertEquals(500, difficultFinal.getHealth(), 0);
    }

    @Test
    public void finalMonsterAttack() {
        Player easy = new Player("easyCheck", Weapon.SPEAR, 750, "Easy");
        Player medium = new Player("mediumCheck", Weapon.SPEAR, 750, "Medium");
        Player difficult = new Player("difficultCheck", Weapon.SPEAR, 750, "Difficult");
        Monster easyFinal = new MonsterFinal(easy);
        Monster mediumFinal = new MonsterFinal(medium);
        Monster difficultFinal = new MonsterFinal(difficult);
        assertEquals(25, easyFinal.getDamageGivenAmount(), 0);
        assertEquals(30, mediumFinal.getDamageGivenAmount(), 0);
        assertEquals(35, difficultFinal.getDamageGivenAmount(), 0);
    }
}
