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

public class Profile {

    @FXML
    private Label Level_Archer;

    @FXML
    private Label Level_Wizard;

    @FXML
    private Label Level_Valkyrie;

    @FXML
    private Label Level_BabyDragon;

    @FXML
    private Label Level_Giant;

    @FXML
    private Label Level_Pakka;

    @FXML
    private Label Level_FireBall;

    @FXML
    private Label Level_Rage;

    @FXML
    private Label Level_Cannon;

    @FXML
    private Label Level_InfernoTower;

    @FXML
    private Label Level_Barbar;

    @FXML
    private Label Level_Arrows;

    @FXML
    void Update(MouseEvent event) {
       Level_Barbar.setText("Level 1");
       Level_Archer.setText("Level 1");
       Level_Arrows.setText("Level 1");
       Level_Cannon.setText("Level 1");
       Level_Giant.setText("Level 1");
       Level_BabyDragon.setText("Level 1");
       Level_InfernoTower.setText("Level 1");
       Level_Pakka.setText("Level 1");
       Level_Valkyrie.setText("Level 1");
       Level_Wizard.setText("Level 1");
       Level_Rage.setText("Level 1");
       Level_FireBall.setText("Level 1");
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
