package ui;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        LoginScreen loginScreen = new LoginScreen();
        loginScreen.showLoginWindow();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
