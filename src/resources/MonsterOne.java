package resources;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MonsterOne extends Monster {
    public MonsterOne(Player player) {
        this.setMonsterType("Green Slime");
        this.setPlayer(player);
        this.setMonsterImage(new ImageView(new Image("content/Monster1/monster10.png")));
        this.getChildren().add(this.getMonsterImage());
        if (player.getDifficulty().equalsIgnoreCase("easy")) {
            this.setHealth(100);
            this.setDamageGivenAmount(10);
        } else if (player.getDifficulty().equalsIgnoreCase("medium")) {
            this.setHealth(150);
            this.setDamageGivenAmount(15);
        } else {
            this.setHealth(200);
            this.setDamageGivenAmount(20);
        }
    }
}
