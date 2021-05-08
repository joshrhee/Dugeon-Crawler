package resources;

import javafx.scene.image.Image;

public class ShieldPotion extends Item {



    public ShieldPotion(boolean onScreen, Player player) {
        this.setActive(false);
        this.setOnScreen(onScreen);
        this.setIm(new Image("content/Shield.png"));
        this.setPlayer(player);
        setPrice(350);
        setType("Shield");
    }

    @Override
    public void activate() {
        this.getPlayer().setShield(this.getPlayer().getShield() + 7);
        //this.setActive(false);
    }


}
