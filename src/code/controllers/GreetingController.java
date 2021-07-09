package code.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class GreetingController {
    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;


    public void login(ActionEvent actionEvent) throws IOException {
        Button btn = (Button) actionEvent.getSource();
        System.out.println(btn.getId());
        Stage statge = (Stage) btn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/login.fxml"));
        Parent parent = loader.load();
        LoginController lc = loader.getController();
        lc.setUsername("hamed");
        statge.setScene(new Scene(parent));
    }


    public void register(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) this.loginBtn.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../../res/fxml/register.fxml"));
        Parent parent = loader.load();
        stage.setScene(new Scene(parent));


    }
}
