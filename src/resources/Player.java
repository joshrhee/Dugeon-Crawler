package resources;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;

public class Player extends ImageView {

    private String name;
    private Weapon weapon;
    private int health;
    private int moneyValue;
    private boolean attackMode;
    private boolean movingRight;
    private Image playerImage;
    private String textX;
    private String textY;
    private int damageDone;
    private boolean isDead;
    private String difficulty;
    private ArrayList<Item> inventory;
    private int increasedAttack;
    private int shield;
    private int totalHitCount;

    public Player() {
    }

    public Player(String name, Weapon weapon, int moneyValue, String difficulty) {
        this.name = name;
        this.weapon = weapon;
        this.moneyValue = moneyValue;
        this.setDifficulty(difficulty);
        health = 100;
        if (this.getDifficulty().equalsIgnoreCase("difficult")) {
            damageDone = 30;
        } else if (this.getDifficulty().equalsIgnoreCase("medium")) {
            damageDone = 25;
        } else {
            damageDone = 20;
        }
        attackMode = false;
        movingRight = true;
        isDead = false;
        setShield(0);
        this.setImage(setImageAs(weapon));
        this.setOnKeyPressed(keyPressed());
        this.setOnKeyReleased(keyReleased());
        this.setFocusTraversable(true);
        inventory = new ArrayList<>();
        increasedAttack = 0;
        totalHitCount = 0;
    }

    // Sets default image of player based on weapon chosen during configuration.
    private Image setImageAs(Weapon weapon) {
        if (weapon == Weapon.GUN) {
            this.playerImage = notAttackModeGun();
        } else if (weapon == Weapon.SWORD) {
            this.playerImage = notAttackModeSword();
        } else if (weapon == Weapon.SPEAR) {
            this.playerImage = notAttackModeSpear();
        }
        return playerImage;
    }

    // Player in attackMode with Gun.
    private void inAttackModeGun() {
        Image inAttack;
        if (movingRight) {
            inAttack = new Image("content/player_Models/player_Model10.png");
        } else {
            inAttack = new Image("content/player_Models/player_Model11.png");
        }
        this.setImage(inAttack);
    }

    // Player in attackMode with Sword.
    private void inAttackModeSword() {
        Image inAttack;
        if (movingRight) {
            inAttack = new Image("content/player_Models/player_Model04.png");
        } else {
            inAttack = new Image("content/player_Models/player_Model05.png");
        }
        this.setImage(inAttack);
    }

    // Player in attackMode with Spear.
    private void inAttackModeSpear() {
        Image inAttack;
        if (movingRight) {
            inAttack = new Image("content/player_Models/player_Model08.png");
        } else {
            inAttack = new Image("content/player_Models/player_Model09.png");
        }
        this.setImage(inAttack);
    }

    // Player not in attackMode with Gun.
    private Image notAttackModeGun() {
        Image inAttack;
        if (movingRight) {
            inAttack = new Image("content/player_Models/player_Model00.png");
        } else {
            inAttack = new Image("content/player_Models/player_Model01.png");
        }
        this.setImage(inAttack);
        return inAttack;
    }

    // Player not in attackMode with Sword.
    private Image notAttackModeSword() {
        Image inAttack;
        if (movingRight) {
            inAttack = new Image("content/player_Models/player_Model02.png");
        } else {
            inAttack = new Image("content/player_Models/player_Model03.png");
        }
        this.setImage(inAttack);
        return inAttack;
    }

    // Player not in attackMode with Spear.
    private Image notAttackModeSpear() {
        Image inAttack;
        if (movingRight) {
            inAttack = new Image("content/player_Models/player_Model06.png");
        } else {
            inAttack = new Image("content/player_Models/player_Model07.png");
        }
        this.setImage(inAttack);
        return inAttack;
    }

    // EventHandler moves player image around field and allows attack.
    private EventHandler<KeyEvent> keyPressed() {
        return keyEvent -> {
            switch (keyEvent.getCode()) {
            case W:
            case UP:
                this.setY(this.getY() - 10);
                textY = "Y: " + ((int) this.getY());
                break;
            case S:
            case DOWN:
                this.setY(this.getY() + 10);
                textY = "Y: " + ((int) this.getY());
                break;
            case D:
            case RIGHT:
                movingRight = true;
                this.setX(this.getX() + 10);
                textX = "X: " + ((int) this.getX());
                if (weapon == Weapon.GUN) {
                    notAttackModeGun();
                } else if (weapon == Weapon.SWORD) {
                    notAttackModeSword();
                } else if (weapon == Weapon.SPEAR) {
                    notAttackModeSpear();
                }
                movingRight = true;
                break;
            case A:
            case LEFT:
                movingRight = false;
                this.setX(this.getX() - 10);
                textX = "X: " + ((int) this.getX());
                if (weapon == Weapon.GUN) {
                    notAttackModeGun();
                } else if (weapon == Weapon.SWORD) {
                    notAttackModeSword();
                } else if (weapon == Weapon.SPEAR) {
                    notAttackModeSpear();
                }
                movingRight = false;
                break;
            case SPACE:
                attackMode = true;
                if (weapon == Weapon.GUN) {
                    inAttackModeGun();
                } else if (weapon == Weapon.SWORD) {
                    inAttackModeSword();
                } else if (weapon == Weapon.SPEAR) {
                    inAttackModeSpear();
                }
                break;
            default:
                break;
            }
        };
    }

    // EventHandler displays non-attacking player when Space Bar is released.
    private EventHandler<KeyEvent> keyReleased() {
        return keyEvent -> {
            switch (keyEvent.getCode()) {
            case SPACE:
                attackMode = false;
                totalHitCount++;
                if (weapon == Weapon.GUN) {
                    notAttackModeGun();
                } else if (weapon == Weapon.SWORD) {
                    notAttackModeSword();
                } else if (weapon == Weapon.SPEAR) {
                    notAttackModeSpear();
                }
                break;
            default:
                break;
            }
        };
    }

    public String getTextX() {
        return this.textX;
    }
    public String getTextY() {
        return this.textY;
    }

    // Setters and Getters for instance variables.
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        if (shield > 0) {
            shield--;
        } else if (health > 0) {
            this.health = health;
            isDead = false;
        } else {
            isDead = true;
        }
    }

    public boolean getIsDead() {
        return isDead;
    }
    public void setIsDead(boolean isDead) {
        this.isDead = isDead;
    }

    public int getMoneyValue() {
        return moneyValue;
    }
    public void setMoneyValue(int moneyValue) {
        this.moneyValue = moneyValue;
    }

    public Image getPlayerImage() {
        return playerImage;
    }
    public void setPlayerImage(Weapon weapon) {
        if (weapon == Weapon.GUN) {
            notAttackModeGun();
        } else if (weapon == Weapon.SWORD) {
            notAttackModeSword();
        } else if (weapon == Weapon.SPEAR) {
            notAttackModeSpear();
        }
    }

    public boolean isAttackMode() {
        return attackMode;
    }
    public void setAttackMode(boolean attackMode) {
        this.attackMode = attackMode;
    }

    public boolean isMovingRight() {
        return movingRight;
    }
    public void setMovingRight(boolean movingRight) {
        this.movingRight = movingRight;
    }

    public int getDamageDone() {
        return damageDone;
    }
    public void setDamageDone(int damageDone) {
        this.damageDone = damageDone;
    }
    public String getDifficulty() {
        return difficulty;
    }
    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }
    public void setIncreasedAttack(int increasedAttack) {
        if (increasedAttack < 0) {
            this.increasedAttack = 0;
        } else {
            this.increasedAttack = increasedAttack;
        }
    }
    public int getIncreasedAttack() {
        return increasedAttack;
    }

    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    public int getTotalHitCount() {
        return totalHitCount;
    }
}
