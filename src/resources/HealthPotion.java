package resources;

import javafx.scene.image.Image;

public class HealthPotion extends Item {

    public HealthPotion(boolean onScreen, Player player) {

        this.setActive(false);
        this.setIm(new Image("content/Health.png"));
        this.setOnScreen(onScreen);

        this.setPlayer(player);
        setPrice(100);
        setType("Health");
    }

    // Increase Player's HP based on difficulty when Health Potion is activated.
    public void activate() {
        if (getPlayer().getDifficulty().equals("Easy")) {
            getPlayer().setHealth(getPlayer().getHealth() + 20);
        } else if (getPlayer().getDifficulty().equals("Medium")) {
            getPlayer().setHealth(getPlayer().getHealth() + 15);
        } else if (getPlayer().getDifficulty().equals("Difficult")) {
            getPlayer().setHealth(getPlayer().getHealth() + 10);
        }
        System.out.println("health used");
        //this.active = false;
        //this.setActive(false);
    }
}
