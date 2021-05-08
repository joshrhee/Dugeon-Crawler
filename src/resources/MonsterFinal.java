package resources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterFinal extends Monster {
    public MonsterFinal(Player player) {
        this.setMonsterType("Final");
        this.setPlayer(player);
        this.setMonsterImage(new ImageView(new Image("content/FinalBoss.png")));
        this.getChildren().add(this.getMonsterImage());
        if (player.getDifficulty().equalsIgnoreCase("easy")) {
            this.setHealth(300);
            this.setDamageGivenAmount(25);
        } else if (player.getDifficulty().equalsIgnoreCase("medium")) {
            this.setHealth(400);
            this.setDamageGivenAmount(30);
        } else {
            this.setHealth(500);
            this.setDamageGivenAmount(35);
        }
    }
}
