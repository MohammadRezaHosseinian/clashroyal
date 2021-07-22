package code.main;

/*
 **
 *                 Thursday, July 22, 2021
 * MohammadReza Hosseinian and Mahdi Mansouriehkhah
 * ClashRoyal Game FinalProject From AmirKabir University
 **
 */

import code.dbms.InitilizerDB;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start( Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../res/fxml/greeting.fxml"));
        primaryStage.setTitle("AUT Clash Royal");
        primaryStage.setScene(new Scene(root, 1200,600));
        primaryStage.show();

    }


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        InitilizerDB.init();
        launch(args);
    }
}
