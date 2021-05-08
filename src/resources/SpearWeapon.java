package resources;

import javafx.scene.image.Image;

public class SpearWeapon extends Item {
    private Image spearWeaponImage;

    public SpearWeapon(boolean onScreen, Player player) {
        this.setActive(false);
        this.setIm(new Image("content/spearItem.png"));
        this.setOnScreen(onScreen);
        this.setPlayer(player);
        setPrice(200);
        setType("SPEAR");
    }

    @Override
    public void activate() {
        Weapon spear = Weapon.SPEAR;
        this.getPlayer().setWeapon(spear);
        this.getPlayer().setPlayerImage(spear);
        this.setActive(false);
    }
}
