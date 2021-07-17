package code.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Battle_History {

    @FXML
    private Label first_game;

    @FXML
    private Label second_game;

    @FXML
    private Label third_game;

    @FXML
    void Update(MouseEvent event) {

        first_game.setText("2-3                   Lost");

    }

    @FXML
    void Back(ActionEvent event) throws IOException {


        Parent root = FXMLLoader.load(getClass().getResource("/res/sample.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
