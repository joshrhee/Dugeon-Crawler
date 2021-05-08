package scenes;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import resources.Player;

public class WinningScreen {

    private Button goBackConfigureScreenBtn;
    private Button endGameBtn;

    private Label statement;

    private Stage mainWindow;

    private BorderPane rootPane;

    private String playerName;
    private int moneyVal;
    private int playerHealth;
    private int totalHittingCount;
    private boolean playerAlive;

    //Constructor
    public WinningScreen(Stage primaryStage, Player player) {

        playerName = player.getName();
        moneyVal = player.getMoneyValue();
        playerHealth = player.getHealth();
        totalHittingCount = player.getTotalHitCount();
        if (player.getIsDead()) {
            playerAlive = false;
        } else {
            playerAlive = true;
        }

        mainWindow = primaryStage;
        if (!(player.getIsDead())) {
            mainWindow.setTitle("Winning Screen");
        } else {
            mainWindow.setTitle("End Screen");
        }
    }

    //Starting this screen
    public void start() {
        initWinningScreen();
    }

    //This method controls all other methods
    public void initWinningScreen() {
        rootPane = new BorderPane();

        goBackConfigureScreenBtn = new Button("Restart");
        endGameBtn = new Button("End Game");
        this.goBackToConfigureScreen(goBackConfigureScreenBtn);
        this.finishGame(endGameBtn);

        HBox btnBox = this.getButtons(goBackConfigureScreenBtn, endGameBtn);
        Label winningStatement = this.getStatement();

        this.combineAll(rootPane, btnBox, statement);
        this.getScreen(rootPane);
    }

    //Making Button
    public void goBackToConfigureScreen(Button goBackConfigureScreenBtn) {
        goBackConfigureScreenBtn.setId("goBackConfigureScreenBtn");

        //Adding button's functionality
        goBackConfigureScreenBtn.setOnAction(e -> {
            Configure cs = new Configure(mainWindow);
            cs.start(mainWindow);
        });
    }

    public void finishGame(Button endGameBtn) {
        endGameBtn.setId("endGameBtn");

        //Adding button's functionality
        endGameBtn.setOnAction(e -> {
            mainWindow.close();
        });
    }

    public HBox getButtons(Button goBackConfigureScreenBtn, Button endGameBtn) {
        HBox btnHbox = new HBox();
        btnHbox.setSpacing(20);
        btnHbox.setPadding(new Insets(10, 10, 180, 300));
        btnHbox.getChildren().addAll(goBackConfigureScreenBtn, endGameBtn);

        return btnHbox;
    }

    public Label getStatement() {
        if (playerAlive) {
            statement = new Label(" Congratulations! " + playerName + " You completed this game! "
                    + "\n            You completed this game with " + playerHealth + " health and "
                    + "\n                             your remaining money is " + moneyVal
                    + "\n                          You hit total " + totalHittingCount
                    + " for all monsters!");
            statement.setPadding(new Insets(140, 0, 0, 90));
        } else {
            statement = new Label("                                             Game Over..."
                    + "\n You were defeated because your health becomes " + 0 + "."
                    + "\n But you earned " + moneyVal + " and you hit total " + totalHittingCount
                    + " for all monsters!");
            statement.setPadding(new Insets(140, 0, 0, 100));
        }

        return statement;
    }

    public void combineAll(BorderPane rootPane, HBox btnHbox, Label statement) {
        rootPane.setTop(statement);
        rootPane.setBottom(btnHbox);
    }

    public void getScreen(BorderPane rootPane) {
        Scene rootScene = new Scene(rootPane, 950, 650);

        rootScene.getStylesheets().add("styles/WinningScreenStyle.css");
        mainWindow.setScene(rootScene);
        mainWindow.show();
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public void setPlayerHealth(int playerHealth) {
        this.playerHealth = playerHealth;
    }

    public int getTotalHittingCount() {
        return totalHittingCount;
    }

    public int getMoneyVal() {
        return moneyVal;
    }
}
