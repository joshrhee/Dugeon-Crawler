package resources;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public abstract class Monster extends VBox {
    private double health;
    private int damageGivenAmount;
    private double x;
    private double y;
    private boolean isDead;
    private ImageView monsterImage;
    private String monsterType;
    private Player player;
    private int attackCount = 0;

    public double getHealth() {
        return this.health;
    }
    public void setDamageTaken(double damageTaken) {
        attackCount++;
        if (this.health - damageTaken <= 0) {
            isDead = true;
            health = 0;
        } else {
            this.health = this.health - damageTaken;
        }
    }
    public int getDamageGivenAmount() {
        return damageGivenAmount;
    }
    public String getMonsterType() {
        return this.monsterType;
    }
    public String getTextX() {
        return "" + this.x;
    }
    public String getTextY() {
        return "" + this.y;
    }
    public boolean getIsDead() {
        return this.isDead;
    }
    public ImageView getMonsterImage() {
        return this.monsterImage;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public boolean isDead() {
        return isDead;
    }

    public Player getPlayer() {
        return player;
    }

    public int getAttackCount() {
        return attackCount;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public void setDamageGivenAmount(int damageGivenAmount) {
        this.damageGivenAmount = damageGivenAmount;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public void setMonsterImage(ImageView monsterImage) {
        this.monsterImage = monsterImage;
    }

    public void setMonsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
