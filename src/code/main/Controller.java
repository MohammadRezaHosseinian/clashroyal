package code.main;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    @FXML
    private Button Battle_Deck;

    @FXML
    private Button Battle_History;

    @FXML
    private Button Profile;

    @FXML
    private Button Training_Camp;

    @FXML
    void Home_Page(ActionEvent e) throws IOException {
        if (e.getSource() == Profile) {

            Parent root = FXMLLoader.load(getClass().getResource("/res/Profile.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        if(e.getSource() == Battle_Deck){

            Parent root = FXMLLoader.load(getClass().getResource("/res/Battle_Deck.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }
        if(e.getSource() == Battle_History){

            Parent root = FXMLLoader.load(getClass().getResource("/res/Battle_History.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

        if(e.getSource() == Training_Camp){

            Parent root = FXMLLoader.load(getClass().getResource("/res/Training_Camp.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node)e.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }
}
