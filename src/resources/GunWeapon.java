package resources;

import javafx.scene.image.Image;

public class GunWeapon extends Item {

    private Image gunWeaponImage;

    public GunWeapon(boolean onScreen, Player player) {
        this.setActive(false);
        this.setIm(new Image("content/gunItem.png"));
        this.setOnScreen(onScreen);
        this.setPlayer(player);
        setPrice(200);
        setType("Gun");
    }

    @Override
    public void activate() {
        Weapon gun = Weapon.GUN;
        this.getPlayer().setWeapon(gun);
        this.getPlayer().setPlayerImage(gun);
        this.setActive(false);

    }
}
