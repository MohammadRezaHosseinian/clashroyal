package code.controllers;

/*
 **
 * this class helps for handle greeting page
 **
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class GreetingController {
    @FXML
    public AnchorPane parent;
    @FXML
    public ImageView welcomeImage;
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;


    @FXML
    public void initialize() {
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT
        );
        this.parent.setBackground(new Background(bi));
        Image welcome = new Image(Defaults.WELCOME_IMAGE_URI);
        this.welcomeImage.setImage(welcome);
    }


    public void login(ActionEvent actionEvent) throws IOException {
        Button btn = (Button) actionEvent.getSource();
        System.out.println(btn.getId());
        Stage stage = (Stage) btn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/login.fxml"));
        Parent parent = loader.load();
        LoginController lc = loader.getController();
        stage.setScene(new Scene(parent));
    }


    public void register(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.loginBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/register.fxml"));
        Parent parent = loader.load();
        stage.setScene(new Scene(parent));


    }
}
