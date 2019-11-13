package cz.sspbrno.bookstore;

import java.io.File;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends Application {

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root  = new FXMLLoader(getClass().getClassLoader().getResource("store.fxml")).load();
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setTitle("Knihovna");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
