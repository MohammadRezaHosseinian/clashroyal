/**
 * Sample Skeleton for 'Battle_Deck.fxml' Controller Class
 */

package code.main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Battle_Deck {

    ImageView imageView1;

    @FXML // fx:id="Image_Barbar"
    private ImageView Image_Barbar; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Archer"
    private ImageView Image_Archer; // Value injected by FXMLLoader

    @FXML // fx:id="Image_BabyDragon"
    private ImageView Image_BabyDragon; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Valkyrie"
    private ImageView Image_Valkyrie; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Giant"
    private ImageView Image_Giant; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Wizard"
    private ImageView Image_Wizard; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Cannon"
    private ImageView Image_Cannon; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Rage"
    private ImageView Image_Rage; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Arrows"
    private ImageView Image_Arrows; // Value injected by FXMLLoader

    @FXML // fx:id="Image_FireBall"
    private ImageView Image_FireBall; // Value injected by FXMLLoader

    @FXML // fx:id="Image_InfernoTower"
    private ImageView Image_InfernoTower; // Value injected by FXMLLoader

    @FXML // fx:id="Image_Pakka"
    private ImageView Image_Pakka; // Value injected by FXMLLoader


    @FXML
    void Selected(MouseEvent event) {
        imageView1 = (ImageView) event.getSource();
        imageView1.setImage(null);
    }

    @FXML
    void Replace_Card(MouseEvent event) {

        imageView1.setImage(((ImageView) event.getSource()).getImage());
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
