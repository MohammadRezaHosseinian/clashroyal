package code.main;

import code.dbms.InitilizerDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

public class Main extends Application {

    @Override
    public void start(@NotNull Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../res/fxml/fight.fxml"));
        primaryStage.setTitle("AUT Clash Royal");
        primaryStage.setScene(new Scene(root, 900,600));
        primaryStage.show();

    }


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        InitilizerDB.init();
        launch(args);
    }
}
