package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import sample.Main;

public class HelpScene extends Main {

    private Label description1;
    private Label description2;
    private Label description3;
    private Label description4;

    private Stage mainWindow;

    //Constructor
    public HelpScene(Stage primaryStage) {
        primaryStage.setTitle("Help Screen");
        mainWindow = primaryStage;
    }

    //Starting this scene
    public void start() {
        initHelpScene();
    }

    //This method controls all other methods
    public void initHelpScene() {
        HelpScene hs = new HelpScene(mainWindow);
        BorderPane rootPane = new BorderPane();

        Button goBackWelcomeScreenBtn = new Button("Go back");
        goBackToWelcomScreen(mainWindow, goBackWelcomeScreenBtn);

        Button goToInstructionScreenBtn = new Button("Go Instruction");
        goToInstructionScreen(mainWindow, goToInstructionScreenBtn);

        HBox btnHbox = hs.getButtons(goBackWelcomeScreenBtn, goToInstructionScreenBtn);
        TilePane descriptionPane = hs.getDescription();

        hs.combineAll(rootPane, btnHbox, descriptionPane);
        hs.getScene(rootPane);
    }

    //Adding button's functionality
    public void goBackToWelcomScreen(Stage mainWindow, Button goBackWelcomeScreenBtn) {
        goBackWelcomeScreenBtn.setId("goBackWelcomeScreenBtn");

        //Adding button's functionality
        goBackWelcomeScreenBtn.setOnAction(e -> {
            Main mainScreen = new Main();
            try {
                mainScreen.start(mainWindow);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        });
    }

    public void goToInstructionScreen(Stage mainWindow, Button goToInstructionBtn) {
        goToInstructionBtn.setId("goToInstructionScreenBtn");

        //Adding button's functionality
        goToInstructionBtn.setOnAction(e -> {
            InstructionScreen is = new InstructionScreen(mainWindow);
            is.start();
        });
    }

    //Combining all buttons
    public HBox getButtons(Button goBackWelcomeScreenBtn, Button goToInstructionBtn) {
        HBox btnHbox = new HBox();
        btnHbox.setSpacing(20);
        btnHbox.setPadding(new Insets(10, 10, 130, 140));
        btnHbox.getChildren().addAll(goBackWelcomeScreenBtn, goToInstructionBtn);

        return btnHbox;
    }

    //Creating descriptions label and putting into pane
    public TilePane getDescription() {
        description1 = new Label("This game is");
        description2 = new Label("created from CS 2340 NULLGROUP44");
        description3 = new Label("If you have any questions,");
        description4 = new Label("Please reach out to one of our members");

        description1.setId("description1");
        description2.setId("description2");
        description3.setId("description3");
        description4.setId("description4");

        TilePane descriptionPane = new TilePane(Orientation.VERTICAL);
        descriptionPane.setVgap(10);
        descriptionPane.setPadding(new Insets(30, 0, 0, 75));
        descriptionPane.getChildren().addAll(description1, description2,
                description3, description4);
        return descriptionPane;
    }

    //Putting all into the root pane
    public void combineAll(BorderPane rootPane, HBox btnHbox, TilePane descriptionPane) {
        rootPane.setTop(descriptionPane);
        rootPane.setBottom(btnHbox);
    }
    //Showing Scene
    public void getScene(BorderPane rootPane) {
        Scene rootScene = new Scene(rootPane, 700, 500);
        rootScene.getStylesheets().add("styles/HelpSceneStyle.css");
        mainWindow.setScene(rootScene);
        mainWindow.show();
    }
}
