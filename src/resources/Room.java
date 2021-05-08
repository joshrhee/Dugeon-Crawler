package resources;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Room extends Pane {
    private Door nDoor;
    private Door eDoor;
    private Door sDoor;
    private Door wDoor;
    private Room nRoom;
    private Room eRoom;
    private Room sRoom;
    private Room wRoom;
    private Player player;
    private Text roomNumber;
    private Button gameEndButton;
    private ExitTreasure treasureChest;
    private boolean isSafe;
    private Monster monster;
    private ArrayList<Monster> monsters;
    private Timeline t1;
    private Button buyHealthPotion;
    private Button buyAttackPotion;
    private Button buyShieldPotion;
    private Button buySwordWeapon;
    private Button buyGunWeapon;
    private Button buySpearWeapon;
    private Label label;
    private Label shopText;
    private VisInv inv;

    public Room(String roomNumber) {
        this.roomNumber = new Text(roomNumber);
        this.getChildren().add(this.roomNumber);
        this.roomNumber.setTextAlignment(TextAlignment.CENTER);
        this.roomNumber.relocate(210, 300);
        this.roomNumber.setFont(Font.font("Arial", FontWeight.BOLD, 70));
        this.isSafe = false;
        this.monsters = new ArrayList<Monster>();
        this.setPrefSize(950, 650);
        this.setMaxSize(950, 650);
        this.setId("GameRoot");
        this.getStylesheets().add("styles/GsStyle.css");
        //oomLoop();
    }

    public Monster getMonster() {
        return this.monster;
    }
    public void setMonster(Monster monster) {
        this.monster = monster;
        this.monsters.add(monster);
        this.getChildren().add(this.monster);
        this.monsters.get(0).relocate(590, 225);
    }

    public boolean getIsSafe() {
        return isSafe;
    }

    public void setIsSafe(boolean isSafe) {
        this.isSafe = isSafe;
    }

    public Door getnDoor() {
        return nDoor;
    }

    public Door geteDoor() {
        return eDoor;
    }

    public Door getsDoor() {
        return sDoor;
    }

    public Door getwDoor() {
        return wDoor;
    }

    public Room getnRoom() {
        return nRoom;
    }

    public Room geteRoom() {
        return eRoom;
    }

    public Room getsRoom() {
        return sRoom;
    }

    public Room getwRoom() {
        return wRoom;
    }

    public void setnDoor(Door nDoor) {
        this.nDoor = nDoor;
        this.getChildren().add(this.nDoor);
        this.nDoor.relocate(475, -15);
    }

    public void seteDoor(Door eDoor) {
        this.eDoor = eDoor;
        this.getChildren().add(this.eDoor);
        this.eDoor.relocate(870, 250);
        eDoor.setRotate(90);
    }

    public void setsDoor(Door sDoor) {
        this.sDoor = sDoor;
        this.getChildren().add(this.sDoor);
        this.sDoor.relocate(475, 553);
        sDoor.setRotate(180);
    }

    public void setwDoor(Door wDoor) {
        this.wDoor = wDoor;
        this.getChildren().add(this.wDoor);
        this.wDoor.relocate(-15, 250);
        wDoor.setRotate(270);
    }

    public void setNRoom(Room nRoom) {
        this.nRoom = nRoom;
        this.setnDoor(new Door());
    }

    public void setERoom(Room eRoom) {
        this.eRoom = eRoom;
        this.seteDoor(new Door());
    }

    public void setSRoom(Room sRoom) {
        this.sRoom = sRoom;
        this.setsDoor(new Door());
    }

    public void setWRoom(Room wRoom) {
        this.wRoom = wRoom;
        this.setwDoor(new Door());
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        if (this.player == null) {
            this.player = player;
        }
        addPlayer();
        this.player.relocate(475, 225);
    }

    public void passPlayer(Room nextRoom) {
        nextRoom.setPlayer(this.getPlayer());
        this.getChildren().remove(this.player);
        //this.setPlayer(null);
    }

    public void addPlayer() {
        this.getChildren().add(this.player);
    }

    public String getRoomText() {
        return roomNumber.getText();
    }

    public void setTreasure(Stage primaryStage, Player player) {
        treasureChest = new ExitTreasure(primaryStage, player);
        this.getChildren().add(treasureChest);
        this.treasureChest.relocate(700, 200);
        this.treasureChest.setRotate(90);
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }

    public void checkInteraction() {
        for (int i = 0; i < monsters.size(); i++) {

            if (monsters.get(i) != null && this.player != null) {
                if (this.getPlayer().getBoundsInParent()
                        .intersects(monsters.get(i).getBoundsInParent())) {
                    if (this.player.isAttackMode()) {
                        if (player.getIncreasedAttack() > 0) {
                            monsters.get(i).setDamageTaken(this.player.getDamageDone() + 15);
                            player.setIncreasedAttack(getPlayer().getIncreasedAttack() - 1);
                        } else {
                            monsters.get(i).setDamageTaken(this.player.getDamageDone());
                        }
                    }
                    int randNumber = (int) (Math.random() * 20);
                    if (randNumber == 1) {
                        player.setHealth(player.getHealth()
                                - monsters.get(i).getDamageGivenAmount());
                        this.player.setX(this.player.getX() - 50);
                    }
                    if (monsters.get(i).getIsDead()) {
                        int moneyGiven = (int) (Math.random() * 26) + 25;
                        this.getChildren().remove(this.monsters.get(i));
                        this.player.setMoneyValue(this.player.getMoneyValue() + moneyGiven);
                        //this.monster = null;
                        monsters.remove(i);
                        i--;
                        if (monsters.size() == 0) {
                            this.setIsSafe(true);
                        }
                    }
                }
            }
        }
    }
    public Text getRoomNumber() {
        return roomNumber;
    }

    private void buyItem(String itemType) {
        System.out.println(player.getInventory().size() + ", " + player.getInventory().toString());
        if (player.getInventory().size() < 5) {

            if (itemType.equals("Health")) {
                if (checkEnoughMoney(100)) {
                    Item healthPotion = new HealthPotion(false, getPlayer());
                    this.getPlayer().getInventory().add(healthPotion);
                    this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() - 100);
                    inv.addItem(healthPotion);
                    inv.update();
                } else {
                    label.setText("Not enough money!");
                }
            } else if (itemType.equals("Attack")) {
                if (checkEnoughMoney(250)) {
                    Item attackPotion = new AttackPotion(false, getPlayer());
                    this.getPlayer().getInventory().add(attackPotion);
                    this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() - 250);
                    inv.addItem(attackPotion);
                    inv.update();
                } else {
                    label.setText("Not enough money!");
                }
            } else if (itemType.equals("Shield")) {
                if (checkEnoughMoney(350)) {
                    Item shieldPotion = new ShieldPotion(false, getPlayer());
                    this.getPlayer().getInventory().add(shieldPotion);
                    this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() - 350);
                    inv.addItem(shieldPotion);
                    inv.update();
                } else {
                    label.setText("Not enough money!");
                }
            } else if (itemType.equals("Gun")) {
                if (checkEnoughMoney(200)) {
                    Item gunWeapon = new GunWeapon(false, getPlayer());
                    this.getPlayer().getInventory().add(gunWeapon);
                    this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() - 200);
                    inv.addItem(gunWeapon);
                    inv.update();
                } else {
                    label.setText("Not enough money!");
                }
            } else if (itemType.equals("Sword")) {
                if (checkEnoughMoney(200)) {
                    Item swordWeapon = new SwordWeapon(false, getPlayer());
                    this.getPlayer().getInventory().add(swordWeapon);
                    this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() - 200);
                    inv.addItem(swordWeapon);
                    inv.update();
                } else {
                    label.setText("Not enough money!");
                }
            } else if (itemType.equals("Spear")) {
                if (checkEnoughMoney(200)) {
                    Item spearWeapon = new SpearWeapon(false, getPlayer());
                    this.getPlayer().getInventory().add(spearWeapon);
                    this.getPlayer().setMoneyValue(this.getPlayer().getMoneyValue() - 200);
                    inv.addItem(spearWeapon);
                    inv.update();
                } else {
                    label.setText("Not enough money!");
                }
            }
        } else {
            label.setText("Inventory Full");
        }
    }

    private boolean checkEnoughMoney(int price) {
        return getPlayer().getMoneyValue() >= price;
    }

    private EventHandler<ActionEvent> buyHealth = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            buyItem("Health");
        }
    };

    private EventHandler<ActionEvent> buyAttack = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            buyItem("Attack");
        }
    };

    private EventHandler<ActionEvent> buyShield = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            buyItem("Shield");
        }
    };

    private EventHandler<ActionEvent> buyGun = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            buyItem("Gun");
        }
    };
    private EventHandler<ActionEvent> buySword = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            buyItem("Sword");
        }
    };
    private EventHandler<ActionEvent> buySpear = new EventHandler<ActionEvent>() {
        public void handle(ActionEvent e) {
            buyItem("Spear");
        }
    };

    private void makeAndAddItems() {
        buyHealthPotion = new Button("Potion: Health");
        buyAttackPotion = new Button("Potion: Attack");
        buyShieldPotion = new Button("Potion: Shield");
        buySwordWeapon = new Button("Weapon: Sword");
        buyGunWeapon = new Button("Weapon: Gun");
        buySpearWeapon = new Button("Weapon: Spear");
        label = new Label("");
        shopText = new Label("STORE: ");
        this.getChildren().addAll(buyHealthPotion, buyAttackPotion, buyShieldPotion,
                label, shopText, buySwordWeapon, buySpearWeapon, buyGunWeapon);
    }

    private void relocateItems() {
        buyAttackPotion.relocate(25, 45);
        buyGunWeapon.relocate(25, 95);
        buyHealthPotion.relocate(145, 45);
        buySwordWeapon.relocate(145, 95);
        buyShieldPotion.relocate(265, 45);
        buySpearWeapon.relocate(265, 95);
        label.relocate(145, 135);
        shopText.relocate(135, 10);
    }

    private void setActions() {
        buyHealthPotion.setOnAction(buyHealth);
        buyAttackPotion.setOnAction(buyAttack);
        buyShieldPotion.setOnAction(buyShield);
        buyGunWeapon.setOnAction(buyGun);
        buySwordWeapon.setOnAction(buySword);
        buySpearWeapon.setOnAction(buySpear);
        buyHealthPotion.setFocusTraversable(false);
        buyAttackPotion.setFocusTraversable(false);
        buyShieldPotion.setFocusTraversable(false);
        buyGunWeapon.setFocusTraversable(false);
        buySpearWeapon.setFocusTraversable(false);
        buySwordWeapon.setFocusTraversable(false);
    }

    private void styleItems() {
        label.setStyle("-fx-text-fill: #FAEBD7");
        shopText.setStyle("-fx-text-fill: #FAEBD7");
        shopText.setFont(Font.font("Arial", FontWeight.BOLD, 20));

    }

    public VisInv getInv() {
        return inv;
    }

    public void setInv(VisInv inv) {
        this.inv = inv;
    }

    public void setUpShop() {
        makeAndAddItems();
        relocateItems();
        setActions();
        styleItems();
    }
}
