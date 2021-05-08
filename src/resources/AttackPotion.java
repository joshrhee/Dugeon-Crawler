package resources;

import javafx.scene.image.Image;

public class AttackPotion extends Item {
    private Image attackPotionImage;

    public AttackPotion(boolean onScreen, Player player) {
        this.setActive(false);
        this.setIm(new Image("content/Attack.png"));
        this.setOnScreen(onScreen);
        this.setPlayer(player);
        setPrice(250);
        setType("Attack");
    }

    @Override
    public void activate() {
        this.getPlayer().setIncreasedAttack(this.getPlayer().getIncreasedAttack() + 10);
        //this.setActive(true);
    }


}
