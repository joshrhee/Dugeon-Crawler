package resources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterThree extends Monster {
    public MonsterThree(Player player) {
        this.setMonsterType("Zombie");
        this.setPlayer(player);
        this.setMonsterImage(new ImageView(new Image("content/Monster 3/Monster 30.png")));
        this.getChildren().add(this.getMonsterImage());
        if (player.getDifficulty().equalsIgnoreCase("easy")) {
            this.setHealth(200);
            this.setDamageGivenAmount(3);
        } else if (player.getDifficulty().equalsIgnoreCase("medium")) {
            this.setHealth(250);
            this.setDamageGivenAmount(6);
        } else {
            this.setHealth(300);
            this.setDamageGivenAmount(9);
        }
    }
}


