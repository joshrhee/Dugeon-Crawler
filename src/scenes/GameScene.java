package scenes;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import resources.*;

public class GameScene  extends VBox {
    private HBox playerStats;
    private Text playerName;
    private Label monsterStats;
    private Text money;
    private Text playerHP;
    private Maze maze;
    private Room curr;
    private Timeline t1;
    private Stage primaryStage;
    private Player player;
    private VisInv inv;

    public GameScene(Stage primaryStage, String name, Player player) {


        maze = new Maze(primaryStage);
        this.primaryStage = primaryStage;
        monsterStats = new Label("");
        playerStats = new HBox(70);
        playerName = new Text(name);
        money = new Text("Money: " + player.getMoneyValue());
        playerHP = new Text("Player Health: " + player.getHealth());
        inv = new VisInv();
        this.player = player;
        inv.addItem(player.getInventory().get(0));
        inv.update();
        curr = maze.getCurrRoom();

        maze.getCurrRoom().setPlayer(this.player);


        playerStats.getChildren().addAll(playerName, playerHP, money, monsterStats);
        this.getChildren().addAll(playerStats, maze.getCurrRoom(), inv);
        this.getStylesheets().add("styles/GsStyle.css");
        currRoomUpdate();

    }


    public HBox getPlayerStats() {
        return playerStats;
    }

    public Text getPlayerName() {
        return playerName;
    }

    public Text getMoney() {
        return money;
    }

    public Text getPlayerHP() {
        return playerHP;
    }

    public Label getMonsterStats() {
        return monsterStats;
    }

    public Maze getMaze() {
        return maze;
    }

    public Room getCurr() {
        return curr;
    }

    public void currRoomUpdate() {
        Runnable r = () -> {
            EventHandler<ActionEvent> h1 = event -> {
                if (player.getIsDead()) {
                    WinningScreen ws = new WinningScreen(primaryStage, player);
                    ws.start();
                    player.setIsDead(false);
                } else {
                    curr = maze.getCurrRoom();
                    curr.setInv(inv);
                    if (curr.getRoomText().equals("Final Room")) {
                        if (curr.getMonster() == null || curr.getMonster().isDead()) {
                            curr.setTreasure(primaryStage, player);
                        }
                    }
                    curr.checkInteraction();
                    this.getChildren().set(1, curr);
                    playerHP.setText("Player Health: " + curr.getPlayer().getHealth());
                    this.playerStats.getChildren().set(1, playerHP);
                    money.setText("Money: " + player.getMoneyValue());
                    this.playerStats.getChildren().set(2, money);
                    this.getChildren().set(0, playerStats);
                    for (int i = 0; i < player.getInventory().size(); i++) {
                        if (player.getInventory().get(i).isActive()) {
                            System.out.println("Remove");
                            player.getInventory().remove(i);
                            i--;
                        }
                    }
                    this.inv = curr.getInv();
                    this.inv.update();
                    this.getChildren().set(2, inv);
                }
                statusUpdate();
            };
            KeyFrame k1 = new KeyFrame(Duration.millis(115), h1);
            t1 = new Timeline();
            t1.setCycleCount(Timeline.INDEFINITE);
            t1.getKeyFrames().add(k1);
            t1.play();

        };
        runNow(r);
    }

    private void statusUpdate() {
        if (curr instanceof ChallRoom) {
            monsterStats.setText("                                      "
                    + "                   Monster Left: " + curr.getMonsters().size()
                    + "                                ");

        } else if (curr.getMonster() != null) {
            monsterStats.setText("                                      "
                    + "                   Monster Health: " + curr.getMonster().getHealth()
                    + "                                Monster Type: "
                    + curr.getMonster().getMonsterType());
        } else {
            monsterStats.setText("");
        }
    }

    public static void runNow(Runnable target) {
        Thread t = new Thread(target, "loop");
        t.setDaemon(true);
        t.start();
    }

    public void setCurr(Room curr) {
        this.curr = curr;
    }

    public VisInv getInv() {
        return inv;
    }

    public void setInv(VisInv inv) {
        this.inv = inv;
    }
}
