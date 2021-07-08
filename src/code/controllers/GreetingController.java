package code.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GreetingController {
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;


    public void login(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        System.out.println(btn.getId());
    }


    public void register(ActionEvent actionEvent) {
    }
}
