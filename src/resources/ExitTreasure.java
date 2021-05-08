package resources;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import scenes.WinningScreen;
import scenes.*;

public class ExitTreasure extends ImageView {
    private Image treasure;
    private Player player;
    private Stage mainWindow;

    public ExitTreasure(Stage primaryStage, Player player) {
        treasure = new Image("content/Treasure.png");
        this.player = player;
        mainWindow = primaryStage;
        this.setImage(treasure);
        this.setOnMouseClicked(click());
    }

    public ExitTreasure() {
        treasure = new Image("content/Treasure.png");
        this.setImage(treasure);
        this.setOnMouseClicked(click());
    }


    private EventHandler<? super MouseEvent> click() {
        return event -> {
            WinningScreen winningScreen = new WinningScreen(mainWindow, player);
            winningScreen.start();
        };
    }
    public Image getTreasure() {
        return treasure;
    }

}

