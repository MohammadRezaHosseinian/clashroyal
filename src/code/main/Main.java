package code.main;


import code.card.Inferno_Tower;
import code.card.Rage;

import code.dbms.InitilizerDB;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    static Parent root;

    @Override

    public void start( Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../../res/fxml/fight.fxml"));
        primaryStage.setTitle("AUT Clash Royal");
        primaryStage.setScene(new Scene(root, 900,600));



    }
        public static void main (String[]args) throws ClassNotFoundException {

            launch(args);

        }

}