package resources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterTwo extends Monster {
    public MonsterTwo(Player player) {
        this.setMonsterType("Purple");
        this.setPlayer(player);
        this.setMonsterImage(new ImageView(new Image("content/Monster 2/Monster20.png")));
        this.getChildren().add(this.getMonsterImage());
        if (player.getDifficulty().equalsIgnoreCase("easy")) {
            this.setHealth(50);
            this.setDamageGivenAmount(25);
        } else if (player.getDifficulty().equalsIgnoreCase("medium")) {
            this.setHealth(75);
            this.setDamageGivenAmount(35);
        } else {
            this.setHealth(100);
            this.setDamageGivenAmount(45);
        }
    }
}
