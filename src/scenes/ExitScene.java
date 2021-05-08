package scenes;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import sample.Main;

public class ExitScene extends Main {
    private Button yesBtn;
    private Button noBtn;

    private Label askStatement = new Label("Are you sure to exit?");

    private Stage mainWindow;

    //Constructor
    public ExitScene(Stage primaryStage) {
        mainWindow = primaryStage;
        mainWindow.setTitle("Existing Screen");
    }

    //Starting this scene
    public void start() {
        initExitScene();
    }

    public void initExitScene() {
        ExitScene es = new ExitScene(mainWindow);
        BorderPane rootPane = new BorderPane();

        yesBtn = new Button("Yes");
        exitButton(mainWindow, yesBtn);

        noBtn = new Button("No");
        goBackToWelcomeScreen(noBtn);

        HBox btnHbox = es.getButtons(yesBtn, noBtn);
        Label askStatement = es.getAskStatement();
        es.combineAll(rootPane, btnHbox, askStatement);
        es.getScene(rootPane);
    }

    //Adding button's functionality
    public void exitButton(Stage mainWindow, Button yesBtn) {
        yesBtn.setId("yesBtn");
        yesBtn.setOnAction(e -> {
            mainWindow.close();
        });
    }

    public void goBackToWelcomeScreen(Button noBtn) {
        noBtn.setId("noBtn");
        noBtn.setOnAction(e -> {
            Main mainScreen = new Main();
            try {
                mainScreen.start(mainWindow);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    //Putting all buttons to HBox
    public HBox getButtons(Button yesBtn, Button noBtn) {
        HBox btnHbox = new HBox();
        btnHbox.setSpacing(30);
        btnHbox.getChildren().addAll(yesBtn, noBtn);
        btnHbox.setPadding(new Insets(10, 10, 190, 250));

        return btnHbox;
    }

    //Creating asking statement
    public Label getAskStatement() {
        askStatement.setId("askStatement");
        askStatement.setPadding(new Insets(150, 10, 10, 200));
        return askStatement;
    }

    //Putting all into the root pane
    public void combineAll(BorderPane rootPane, HBox btnHbox, Label askStatement) {
        rootPane.setTop(askStatement);
        rootPane.setBottom(btnHbox);
    }

    //Showing
    public void getScene(BorderPane rootPane) {
        Scene rootScene = new Scene(rootPane, 700, 500);
        rootScene.getStylesheets().add("styles/ExitSceneStyle.css");
        mainWindow.setScene(rootScene);
        mainWindow.show();
    }
}
