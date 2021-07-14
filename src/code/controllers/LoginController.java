package code.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


public class LoginController {

    @FXML
    public AnchorPane parent;
    @FXML
    private Button loginBtn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    public void initialize() {
        BackgroundImage bi = new BackgroundImage(new Image("res//drawable//back.jpg"),
                BackgroundRepeat.NO_REPEAT,BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,BackgroundSize.DEFAULT
                );
        this.parent.setBackground(new Background(bi));
    }
    public void loginHandler(ActionEvent actionEvent) {
        System.out.println(this.username.getText());
    }

    public void setUsername(String name){
        this.username.setText(name);
    }
}
