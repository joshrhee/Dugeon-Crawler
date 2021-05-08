package resources;

import javafx.scene.image.Image;

public class SwordWeapon extends Item {

    private Image swordWeaponImage;

    public SwordWeapon(boolean onScreen, Player player) {
        this.setActive(false);
        this.setIm(new Image("content/swordItempng.png"));
        this.setOnScreen(onScreen);
        this.setPlayer(player);
        setPrice(200);
        setType("Sword");
    }

    @Override
    public void activate() {
        Weapon sword = Weapon.SWORD;
        this.getPlayer().setWeapon(sword);
        this.getPlayer().setPlayerImage(sword);
        this.setActive(false);
    }
}
