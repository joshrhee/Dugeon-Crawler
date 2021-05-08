package sample;

import javafx.application.Application;
import javafx.stage.Stage;
import scenes.WelcomeScreen;

public class Main extends Application {

    private Stage mainWindow;

    //Starting the application
    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        setMainWindow(primaryStage);
        mainWindow.setTitle("Welcome Screen");
        initWelcomeScreen();
    }

    //Initiating Welcome Scree
    private void initWelcomeScreen() {
        WelcomeScreen ws = new WelcomeScreen(mainWindow);
        ws.start();
    }

    public Stage getMainWindow() {
        return this.mainWindow;
    }

    private void setMainWindow(Stage primaryStage) {
        this.mainWindow = primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
