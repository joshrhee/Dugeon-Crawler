package scenes;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class InstructionScreen extends HelpScene {
    private Button goBackHelpSceneBtn = new Button("Go back");

    private Label instruction1 = new Label("As a player, I would like to learn more "
            + "about how to play the game, "
            + " so that when I start the game \n I am able to play proficiently "
            + " and have a better chance of reaching the win screen.");

    private Label instruction2 = new Label("As a player, "
            + "I would like to choose my starting weapon, "
            + "so that when I begin the game and \n "
            + "\n encounter my first obstacle, I am prepared.\n");


    private Label instruction3 = new Label("As a player, I would like to set my own difficulty, "
            + "so that I can play the game at my own comfort level.\n");

    private Label instruction4 = new Label("As a player, I would like to set my own Username, "
            + "so that I can recognize my own character. \n");

    private Label instruction5 = new Label(" As a player, I would like to be able to"
            + " navigate between rooms, " + "\n so that I can proceed through the game/maze.");

    private Stage mainWindow;

    private BorderPane rootPane;

    //Constructor
    public InstructionScreen(Stage primaryStage) {
        super(primaryStage);

        primaryStage.setTitle("Instruction Screen");
        mainWindow = primaryStage;
    }

    //Starting this scene
    public void start() {
        initInstructionScreen();
    }

    //This method controls all other methods
    public void initInstructionScreen() {
        InstructionScreen is = new InstructionScreen(mainWindow);

        TilePane instructionPane = is.getInstruction();
        is.goBackToHelpScreen();
        is.combineAll(instructionPane);
        is.getScene();
    }

    //Making Button
    public void goBackToHelpScreen() {
        goBackHelpSceneBtn.setId("goBackHelpSceneBtn");
        this.goBackHelpSceneBtn.relocate(200, 100);

        //Adding button's functionality
        goBackHelpSceneBtn.setOnAction(e -> {
            HelpScene helpScene = new HelpScene(mainWindow);
            helpScene.start();
        });
    }

    //Creating instructions label and putting into pane
    public TilePane getInstruction() {
        instruction1.setId("instruction1");
        instruction2.setId("instruction2");
        instruction3.setId("instruction3");
        instruction4.setId("instruction4");
        instruction5.setId("instruction5");

        TilePane instructionPane = new TilePane(Orientation.VERTICAL);
        instructionPane.setVgap(1);
        instructionPane.setPadding(new Insets(10, 10, 10, 80));
        instructionPane.getChildren().addAll(instruction1, instruction2,
                instruction3, instruction4, instruction5);
        return instructionPane;
    }

    //Putting all into the root pane
    public void combineAll(TilePane instructionPane) {
        rootPane = new BorderPane();
        rootPane.setTop(instructionPane);
        rootPane.setCenter(goBackHelpSceneBtn);
    }

    //Showing Scene
    public void getScene() {
        Scene rootScene = new Scene(rootPane, 950, 650);
        rootScene.getStylesheets().add("styles/InstructionScreenStyle.css");
        mainWindow.setScene(rootScene);
        mainWindow.show();
    }
}

