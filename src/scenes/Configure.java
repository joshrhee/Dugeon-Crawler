package scenes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import resources.*;
import sample.Main;

public class Configure extends Main {

    private Stage mainWindow;
    private TextField textfield1;
    private ComboBox<Weapon> cbo2;
    private int moneyVal;

    public Configure(Stage primaryStage) {
        primaryStage.setTitle("Configure Screen");
        mainWindow = primaryStage;
    }

    public Configure() {
        this(new Stage());
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        mainWindow = primaryStage;
        BorderPane bpane = new BorderPane();
        bpane.setId("root");
        Text t1 = new Text("Configure Game Screen");
        t1.setTextAlignment(TextAlignment.CENTER);
        t1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
        bpane.setTop(t1);
        bpane.setAlignment(t1, Pos.CENTER);
        GridPane gpane = new GridPane();
        bpane.setCenter(gpane);
        gpane.setVgap(5);
        gpane.setAlignment(Pos.CENTER);
        gpane.add(new Label("Your Name: "),  0, 0);
        textfield1 = new TextField();
        gpane.add(textfield1, 1, 0);
        gpane.add(new Label("Select Difficulty: "),  0, 1);
        ComboBox<String> cbo1 = new ComboBox<>();
        cbo1.getItems().addAll("Easy", "Medium", "Difficult");
        gpane.add(cbo1, 1, 1);
        gpane.add(new Label("Select Weapon: "), 0,  2);
        cbo2 = new ComboBox<>();
        cbo2.getItems().setAll(Weapon.values());
        gpane.add(cbo2, 1, 2);
        Button proceedButton = new Button("Proceed!");
        proceedToGame(proceedButton, textfield1, cbo1, cbo2);
        gpane.add(proceedButton, 1, 3);
        Scene scene = new Scene(bpane, 950,  650);
        scene.getStylesheets().add("styles/ConfigureStyle.css");
        mainWindow.setTitle("Configure Screen");
        mainWindow.setScene(scene);
        mainWindow.show();
    }

    private void proceedToGame(Button b1, TextField t1, ComboBox<String> c1, ComboBox<Weapon> c2) {
        b1.setOnAction(e -> {
            if ((!(t1.getText().trim().isEmpty()) && !(t1 == null))
                    && !(c1.getValue() == null) && !(c2.getValue() == null)) {
                String difficulty = c1.getValue();
                if (difficulty.equals("Easy")) {
                    moneyVal = 750;
                } else if (difficulty.equals("Medium")) {
                    moneyVal = 500;
                } else {
                    moneyVal = 250;
                }

                Player player = new Player(t1.getText(), c2.getValue(), moneyVal, difficulty);
                Item weapon;
                if (c2.getValue() == Weapon.GUN) {
                    weapon = new GunWeapon(false, player);
                } else if (c2.getValue() == Weapon.SPEAR) {
                    weapon = new SpearWeapon(false, player);
                } else {
                    weapon = new SwordWeapon(false, player);
                }
                player.getInventory().add(weapon);

                GameScene gs = new GameScene(mainWindow, t1.getText(), player);
                mainWindow.setTitle("NULLGROUP44");
                mainWindow.setScene(new Scene(gs, 950, 700));
                mainWindow.show();
            }
        });
    }
}

