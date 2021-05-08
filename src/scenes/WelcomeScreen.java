package scenes;

import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class WelcomeScreen extends VBox {
    private Button startBtn;
    private Button helpBtn;
    private Button exitBtn;

    private Label title1;
    private Label title2;
    private Label title3;
    private Label title4;

    private Label name0;
    private Label name1;
    private Label name2;
    private Label name3;
    private Label name4;
    private Label name5;

    private Stage mainWindow;

    //Constructor
    public WelcomeScreen(Stage primaryStage) {
        primaryStage.setTitle("Welcome Screen");
        mainWindow = primaryStage;
    }

    //Starting this scene
    public void start() {
        initWelcomeScreen();
    }

    //This method controls all other methods
    public void initWelcomeScreen() {
        WelcomeScreen ws = new WelcomeScreen(mainWindow);
        BorderPane rootPane = new BorderPane();

        startBtn = new Button("Start");
        startBtn.setPrefSize(120, 20);
        startBtn.setOnAction(e -> {
            goToGameScene();
        });

        helpBtn = new Button("Help");
        helpBtn.setPrefSize(120, 20);
        helpBtn.setOnAction(e -> {
            goToHelpScene();
        });

        exitBtn = new Button("Exit");
        exitBtn.setPrefSize(120, 20);
        exitBtn.setOnAction(e -> {
            goToExitScene();
        });

        //Combining all materials and showing
        VBox btnVbox = ws.getButtons(startBtn, helpBtn, exitBtn);
        TilePane titlePane = ws.getTitles();
        TilePane membersPane = ws.getMembers();

        ws.combineAll(rootPane, btnVbox, titlePane, membersPane);
        ws.getScene(rootPane);
    }

    //Go to Game Scene
    private void goToGameScene() {
        Configure cs = new Configure(mainWindow);
        cs.start(mainWindow);
    }

    //Go to Help Scene
    private void goToHelpScene() {
        HelpScene hs = new HelpScene(mainWindow);
        hs.start();
    }

    //Go to Exit Scene
    private void goToExitScene() {
        ExitScene es = new ExitScene(mainWindow);
        es.start();
    }

    //Putting all buttons into VBox
    public VBox getButtons(Button startBtn, Button helpBtn, Button exitBtn) {
        VBox btnVbox = new VBox();
        btnVbox.setSpacing(20);
        btnVbox.setPadding(new Insets(90, 10, 10, 100));
        btnVbox.getChildren().addAll(startBtn, helpBtn, exitBtn);

        return btnVbox;
    }

    //Creating a title and putting into pane
    public TilePane getTitles() {
        title1 = new Label("WELCOME");
        title2 = new Label("NULLGROUP44'S");
        title3 = new Label("DUNGEON CRAWLER");
        title4 = new Label("STARTING PAGE");


        title1.setId("WELCOME");
        title2.setId("NULLGROUP44");
        title3.setId("DUNGEONCRAWLER");
        title4.setId("STARTINGPAGE");

        TilePane titlePane = new TilePane(Orientation.VERTICAL);
        titlePane.setPadding(new Insets(90, 40, 10, 10));
        titlePane.setVgap(20);
        titlePane.getChildren().addAll(title1, title2, title3, title4);
        return titlePane;
    }

    //Creating team member's list
    public TilePane getMembers() {
        name0 = new Label("Member: ");
        name1 = new Label("Rahul");
        name2 = new Label("Sang");
        name3 = new Label("Stuti");
        name4 = new Label("Reza");
        name5 = new Label("Utkarsh");

        name0.setId("name0");
        name1.setId("name1");
        name2.setId("name2");
        name3.setId("name3");
        name4.setId("name4");
        name5.setId("name5");

        TilePane namePane = new TilePane(Orientation.HORIZONTAL);
        namePane.setPadding(new Insets(10, 10, 50, 60));
        namePane.getChildren().addAll(name0, name1, name2, name3, name4, name5);
        return namePane;
    }

    //Combining all of them into rootPane and showing
    public void combineAll(BorderPane rootPane, VBox btnVbox,
                           TilePane titlePane, TilePane namePane) {
        rootPane.setLeft(btnVbox);
        rootPane.setRight(titlePane);
        rootPane.setBottom(namePane);
    }

    //Showing Scene
    public void getScene(BorderPane rootPane) {
        Scene rootScene = new Scene(rootPane, 700, 500);
        rootScene.getStylesheets().add("styles/WelcomeScreenStyle.css");
        mainWindow.setScene(rootScene);
        mainWindow.show();
    }
}
