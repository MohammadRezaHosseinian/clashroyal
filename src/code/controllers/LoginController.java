package code.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void loginHandler(ActionEvent actionEvent) {
        System.out.println(this.username.getText());
    }

    public void setUsername(String name){
        this.username.setText(name);
    }
}
