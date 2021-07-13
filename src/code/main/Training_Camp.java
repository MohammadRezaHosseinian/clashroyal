package code.main;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Training_Camp {



    @FXML
    void Intelligent_Robot(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/res/Intelligent_Robot.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void Robot(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/res/Robot.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }

}
