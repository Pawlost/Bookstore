package cz.sspbrno.bookstore;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class App extends Application {

    public static void run(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root  = new FXMLLoader(getClass().getClassLoader().getResource("main.fxml")).load();
        Scene scene = new Scene(root, 900, 600);

        primaryStage.setOnCloseRequest((WindowEvent e) -> {
            Platform.exit();
            System.exit(0);
        });

        primaryStage.setTitle("Knihovna");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
